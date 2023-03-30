using System;
using System.Windows.Forms;

namespace Minesweeper
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            bool playAgain = true;

            while (playAgain)
            {
                DifficultyForm difficultyForm = new DifficultyForm();
                DialogResult result = difficultyForm.ShowDialog();

                if (result == DialogResult.OK)
                {
                    GameDifficulty difficulty = difficultyForm.Difficulty;
                    int size;
                    int numMines;

                    switch (difficulty)
                    {
                        case GameDifficulty.Easy:
                            size = 8;
                            numMines = 10;
                            break;
                        case GameDifficulty.Medium:
                            size = 10;
                            numMines = 15;
                            break;
                        case GameDifficulty.Hard:
                            size = 12;
                            numMines = 20;
                            break;
                        default:
                            throw new ArgumentException("Invalid difficulty level.");
                    };

                    Board board = new Board(size, numMines, (int)difficulty);

                    GameForm gameForm = new GameForm(board);
                    DialogResult gameResult = gameForm.ShowDialog();

                    if (gameResult != DialogResult.Retry)
                    {
                        playAgain = false;
                    }
                }
                else
                {
                    playAgain = false;
                }
            }
        }
    }
}