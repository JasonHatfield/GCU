using System;
using System.Windows.Forms;

namespace Minesweeper
{
    public enum GameDifficulty
    {
        Easy = 1,
        Medium = 2,
        Hard = 3
    }

    public partial class DifficultyForm : Form
    {
        public GameDifficulty Difficulty { get; private set; }

        public DifficultyForm() => InitializeComponent();

        private void SetDifficultyAndClose(GameDifficulty difficulty)
        {
            Difficulty = difficulty;
            DialogResult = DialogResult.OK;
            Close();
        }

        private void EasyButton_Click(object sender, EventArgs e) => SetDifficultyAndClose(GameDifficulty.Easy);
        private void MediumButton_Click(object sender, EventArgs e) => SetDifficultyAndClose(GameDifficulty.Medium);
        private void HardButton_Click(object sender, EventArgs e) => SetDifficultyAndClose(GameDifficulty.Hard);
    }
}
