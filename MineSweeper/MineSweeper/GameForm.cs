/**
 * Jason Hatfield
 * This is my original work
 */

using MineSweeper;
using MineSweeper.Properties;
using System;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Windows.Forms;

namespace Minesweeper
{
    public partial class GameForm : Form
    {
        private readonly Board board;
        private bool isGameOver;
        private readonly Stopwatch gameTimer;
        //private readonly PlayerStats playerStats;

        public GameForm(Board board)
        {
            InitializeComponent();
            this.board = board;
            gameTimer = new Stopwatch();
            InitializeGameBoard();
        }

        // Initializes the game board by creating and positioning the cell buttons.
        private void InitializeGameBoard()
        {
            int buttonSize = Math.Min(ClientSize.Width / board.Size, ClientSize.Height / board.Size);
            int totalWidth = board.Size * buttonSize + SystemInformation.VerticalScrollBarWidth;
            int totalHeight = board.Size * buttonSize + SystemInformation.CaptionHeight;
            this.ClientSize = new Size(totalWidth, totalHeight);
            int leftMargin = (ClientSize.Width - board.Size * buttonSize) / 2;
            int topMargin = (ClientSize.Height - board.Size * buttonSize) / 2;

            for (int i = 0; i < board.Size; i++)
            {
                for (int j = 0; j < board.Size; j++)
                {
                    Button cellButton = new Button
                    {
                        Size = new Size(buttonSize, buttonSize),
                        Location = new Point(i * buttonSize + leftMargin, j * buttonSize + topMargin),
                        Tag = new Point(i, j)
                    };

                    Cell cell = board.GetCell(i, j);

                    if (cell.HasMine) // set the background color of the button to gray if it contains a mine
                    {
                        cellButton.BackColor = Color.Gray;
                    }

                    cellButton.MouseDown += CellButton_MouseDown;

                    cellButton.MouseEnter += new EventHandler(CellButton_MouseEnter);
                    cellButton.MouseLeave += new EventHandler(CellButton_MouseLeave);

                    Controls.Add(cellButton);
                }
            }
        }

        // Handles mouse button events for cell buttons.
        private void CellButton_MouseDown(object sender, MouseEventArgs e)
        {
            Button cellButton = (Button)sender;
            Point cellLocation = (Point)cellButton.Tag;

            if (isGameOver)
            {
                return;
            }

            var cell = board.GetCell(cellLocation.X, cellLocation.Y);

            if (e.Button == MouseButtons.Left)
            {
                if (!cell.HasFlag && !cell.HasQuestionMark)
                {
                    if (!gameTimer.IsRunning) // First click
                    {
                        board.PlaceMinesAfterFirstClick(cellLocation.X, cellLocation.Y); // Generate mines after the first click
                        gameTimer.Start();
                        ShowMineButtons(); // Show the mine buttons after the first click
                    }

                    if (cell.HasMine)
                    {
                        isGameOver = true;
                        gameTimer.Stop();
                        RevealMines(cellLocation.X, cellLocation.Y); // Pass the clicked mine's position
                        MessageBox.Show("Game over!");
                    }
                    else
                    {
                        RevealCell(cellButton, cell);
                        CheckForWin();
                    }
                }
            }
            else if (e.Button == MouseButtons.Right)
            {
                ToggleFlag(cellButton, cell);
            }
        }

        // Toggles the flag and question mark state of a cell button.
        private void ToggleFlag(Button cellButton, Cell cell)
        {
            if (cell.IsRevealed) return;

            if (cell.HasFlag)
            {
                cellButton.BackgroundImage = null;
                cellButton.Font = new Font(cellButton.Font.FontFamily, 16, FontStyle.Bold);
                cellButton.ForeColor = Color.Black;
                cellButton.Text = "?";
                cell.HasFlag = false;
                cell.HasQuestionMark = true;
            }
            else if (cell.HasQuestionMark)
            {
                cellButton.BackgroundImage = cellButton.BackgroundImage = null;
                cellButton.Text = "";
                cell.HasQuestionMark = false;
            }
            else
            {
                cellButton.BackgroundImage = Resources.flag;
                cellButton.BackgroundImageLayout = ImageLayout.Stretch;
                cellButton.Text = "";
                cell.HasFlag = true;
            }
        }

        // Checks if the player has won the game.
        public void CheckForWin()
        {
            int flaggedMines = 0;
            int revealedSafeCells = 0;

            for (int i = 0; i < board.Size; i++)
            {
                for (int j = 0; j < board.Size; j++)
                {
                    Cell cell = board.GetCell(i, j);

                    if (cell.HasMine && cell.HasFlag)
                    {
                        flaggedMines++;
                    }

                    if (!cell.HasMine && cell.IsRevealed)
                    {
                        revealedSafeCells++;
                    }
                }
            }

            if (flaggedMines == board.NumMines && revealedSafeCells == board.Size * board.Size - board.NumMines)
            {
                isGameOver = true;
                gameTimer.Stop();
                TimeSpan elapsedTime = gameTimer.Elapsed;

                // Create the input box and set its properties
                Form inputBox = new Form
                {
                    FormBorderStyle = FormBorderStyle.FixedDialog,
                    MaximizeBox = false,
                    MinimizeBox = false,
                    StartPosition = FormStartPosition.CenterParent,
                    Text = "Congratulations! You Win!"
                };

                // Create and configure TableLayoutPanel
                TableLayoutPanel tableLayoutPanel = new TableLayoutPanel
                {
                    ColumnCount = 1,
                    RowCount = 3,
                    Dock = DockStyle.Fill,
                    Padding = new Padding(10)
                };
                inputBox.Controls.Add(tableLayoutPanel);

                // Add a label to the input box
                Label label = new Label
                {
                    Text = "Please enter your initials:",
                    TextAlign = ContentAlignment.MiddleCenter,
                    Dock = DockStyle.Fill,
                    Font = new Font("Segoe UI", 12, FontStyle.Bold)
                };
                tableLayoutPanel.Controls.Add(label, 0, 0);

                // Add a text box to the input box
                TextBox textBox = new TextBox
                {
                    Anchor = AnchorStyles.None,
                    MaxLength = 3,
                    TextAlign = HorizontalAlignment.Center,
                    Font = new Font("Segoe UI", 14, FontStyle.Bold),
                    AutoSize = false,
                    Height = 30,
                    Width = 80
                };
                textBox.KeyPress += TextBox_KeyPress;
                tableLayoutPanel.Controls.Add(textBox, 0, 1);

                // Add a button to the input box
                Button button = new Button
                {
                    Text = "OK",
                    DialogResult = DialogResult.OK,
                    Anchor = AnchorStyles.None
                };
                tableLayoutPanel.Controls.Add(button, 0, 2);

                // Set the size of the input box
                inputBox.ClientSize = new Size(300, 130);

                // Show the input box and wait for the user to enter their initials
                if (inputBox.ShowDialog() == DialogResult.OK)
                {
                    // Get the user's initials and create a PlayerStats instance
                    string initials = textBox.Text.ToUpper();
                    int difficultyLevel = (int)board.Difficulty;
                    PlayerStats playerStats = new PlayerStats(initials, elapsedTime, (GameDifficulty)difficultyLevel);

                    // Save the player's stats
                    playerStats.SavePlayerStats(playerStats);

                    // Create and show the HighScoreForm
                    HighScoreForm highScoreForm = new HighScoreForm();
                    highScoreForm.Show();
                }
            }
        }

        // Reveals the content of a cell and its adjacent cells if the cell has no adjacent mines.
        private void RevealCell(Button cellButton, Cell cell)
        {
            if (cell == null || cellButton == null || cell.IsRevealed || cell.HasFlag || cell.HasQuestionMark) return;

            cellButton.Enabled = false;
            cellButton.BackgroundImage = null;
            cell.IsRevealed = true;

            if (cell.NumAdjacentMines > 0)
            {
                RevealCellWithAdjacentMines(cellButton, cell);
            }
            else
            {
                RevealAdjacentCells(cellButton, cell);
            }
        }

        // Reveals all adjacent cells without mines recursively.
        private void RevealAdjacentCells(Button cellButton, Cell cell)
        {
            if (cell is null)
            {
                throw new ArgumentNullException(nameof(cell));
            }

            int x = (cellButton.Location.X - ((ClientSize.Width - board.Size * cellButton.Width) / 2)) / cellButton.Width;
            int y = (cellButton.Location.Y - ((ClientSize.Height - board.Size * cellButton.Height) / 2)) / cellButton.Height;

            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    int xi = x + i;
                    int yj = y + j;
                    Cell adjacentCell = board.GetCell(xi, yj);
                    Button adjacentCellButton = GetButtonAtLocation(xi, yj);
                    if (adjacentCell != null && !adjacentCell.HasMine && !adjacentCell.IsRevealed && !adjacentCell.HasFlag && !adjacentCell.HasQuestionMark)
                    {
                        RevealCell(adjacentCellButton, adjacentCell);
                    }
                }
            }
        }

        // Reveals a cell containing adjacent mines.
        private void RevealCellWithAdjacentMines(Button cellButton, Cell cell)
        {
            cellButton.Text = cell.NumAdjacentMines.ToString();
            cellButton.Font = new Font(cellButton.Font.FontFamily, 16, FontStyle.Bold);

            Color[] colors = { Color.Blue, Color.Green, Color.Red, Color.DarkBlue, Color.DarkRed, Color.DarkCyan, Color.Black, Color.DarkGray };

            cellButton.ForeColor = colors[cell.NumAdjacentMines - 1];
        }

        private void RevealMines(int clickedMineX, int clickedMineY)
        {
            for (int i = 0; i < board.Size; i++)
            {
                for (int j = 0; j < board.Size; j++)
                {
                    Cell cell = board.GetCell(i, j);
                    Button cellButton = GetButtonAtLocation(i, j);

                    if (cell.HasMine)
                    {
                        if (i == clickedMineX && j == clickedMineY)
                        {
                            cellButton.BackColor = Color.Red;
                        }
                        if (!cell.HasFlag)
                        {
                            cellButton.BackgroundImage = Resources.mine;
                            cellButton.BackgroundImageLayout = ImageLayout.Stretch;
                        }
                    }
                    else if (cell.HasFlag)
                    {
                        cellButton.BackgroundImage = null;
                        cellButton.Font = new Font(cellButton.Font.FontFamily, 16, FontStyle.Bold);
                        cellButton.ForeColor = Color.Black;
                        cellButton.Text = "X";
                    }
                }
            }
            isGameOver = true;
            gameTimer.Stop();
            MessageBox.Show("Game over!");

            // Reset the game and show the difficulty form
            this.Controls.Clear();
            DifficultyForm difficultyForm = new DifficultyForm();
            difficultyForm.ShowDialog();
        }

        public void TextBox_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsLower(e.KeyChar))
            {
                e.KeyChar = char.ToUpper(e.KeyChar);
            }
        }

        private void CellButton_MouseEnter(object sender, EventArgs e)
        {
            Button cellButton = (Button)sender;
            cellButton.Focus();
        }

        private void CellButton_MouseLeave(object sender, EventArgs e)
        {
            this.ActiveControl = null;
        }

        // Returns the button at the specified location on the game board.
        private Button GetButtonAtLocation(int x, int y)
        {
            int leftMargin = (ClientSize.Width - board.Size * (ClientSize.Width / board.Size)) / 2;
            int topMargin = (ClientSize.Height - board.Size * (ClientSize.Height / board.Size)) / 2;

            foreach (Control control in Controls)
            {
                if (control is Button button)
                {
                    if ((button.Location.X - leftMargin) / button.Width == x && (button.Location.Y - topMargin) / button.Height == y)
                    {
                        return button;
                    }
                }
            }
            return null;
        }

        // TODO: This is for testing purposes only, remove before final product.
        private void ShowMineButtons()
        {
            _ = (ClientSize.Width - board.Size * (ClientSize.Width / board.Size)) / 2;
            _ = (ClientSize.Height - board.Size * (ClientSize.Height / board.Size)) / 2;

            for (int i = 0; i < board.Size; i++)
            {
                for (int j = 0; j < board.Size; j++)
                {
                    Cell cell = board.GetCell(i, j);
                    if (cell.HasMine)
                    {
                        Button mineButton = GetButtonAtLocation(i, j);
                        //mineButton.BackColor = Color.Gray;
                    }
                }
            }
        }
    }
}