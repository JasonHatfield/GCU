/**
 * Jason Hatfield
 * This is my original work.
 */

using Minesweeper;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows.Forms;

namespace MineSweeper
{
    // HighScoreForm class represents a form to display the high scores.
    public partial class HighScoreForm : Form
    {
        private const string _playerStatsFilePath = "playerStats.txt";

        public HighScoreForm()
        {
            InitializeComponent();
            DisplayHighScores();
            UpdateColumnWidths();
            highScoresListView.Resize += HighScoresListView_Resize;
        }

        // Event handler for resizing the form.
        private void HighScoresListView_Resize(object sender, EventArgs e)
        {
            UpdateColumnWidths();
        }

        // Updates the column widths based on the form size.
        private void UpdateColumnWidths()
        {
            int columnWidth = highScoresListView.ClientSize.Width / 4;
            for (int i = 0; i < highScoresListView.Columns.Count; i++)
            {
                highScoresListView.Columns[i].Width = columnWidth;
            }
        }

        // Displays the high scores on the form.
        private void DisplayHighScores()
        {
            var playerStats = LoadPlayerStatsFromFile();
            var highScores = GetHighScores(playerStats);

            // add columns to the list view
            highScoresListView.Columns.Add("Player");
            highScoresListView.Columns.Add("Score");
            highScoresListView.Columns.Add("Time");
            highScoresListView.Columns.Add("Difficulty");

            foreach (var highScore in highScores)
            {
                // add an item to the list view for each high score
                var item = new ListViewItem(new[]
                {
                    highScore.Initials,
                    highScore.CalculateScore().ToString(),
                    highScore.TimePlayed.ToString(@"mm\:ss"),
                    highScore.DifficultyLevel.ToString()
                });

                highScoresListView.Items.Add(item);
            }
        }

        // Loads player statistics from a file.
        private List<PlayerStats> LoadPlayerStatsFromFile()
        {
            var playerStats = new List<PlayerStats>();

            try
            {
                using (var sr = new StreamReader(_playerStatsFilePath))
                {
                    while (!sr.EndOfStream)
                    {
                        var line = sr.ReadLine();
                        var tokens = line.Split(',');

                        var initials = tokens[0];
                        var score = int.Parse(tokens[1]);
                        var time = TimeSpan.Parse(tokens[2]);
                        GameDifficulty difficulty = (GameDifficulty)Enum.Parse(typeof(GameDifficulty), tokens[3]);

                        playerStats.Add(new PlayerStats(initials, time, (GameDifficulty)difficulty) { DifficultyLevel = (GameDifficulty)difficulty });
                    }
                }
            }
            catch (IOException ex)
            {
                MessageBox.Show($"Error reading player stats file: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            return playerStats;
        }

        // Gets the top 10 high scores from a list of player statistics.
        private List<PlayerStats> GetHighScores(List<PlayerStats> playerStats)
        {
            return playerStats.OrderByDescending(p => p.CalculateScore()).Take(10).ToList();
        }
    }
}