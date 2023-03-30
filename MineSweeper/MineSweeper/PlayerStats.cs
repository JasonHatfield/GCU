/**
 * Jason Hatfield
 * This is my original work.
 */

using System;
using System.IO;

namespace Minesweeper
{
    // PlayerStats class represents a single player's game statistics.
    public class PlayerStats : IComparable<PlayerStats>
    {
        // Properties for the player's initials, time played, and difficulty level.
        public string Initials { get; set; }
        public TimeSpan TimePlayed { get; set; }
        public GameDifficulty DifficultyLevel { get; set; }

        // Constructor for the PlayerStats class.
        public PlayerStats(string initials, TimeSpan timePlayed, GameDifficulty difficultyLevel)
        {
            Initials = initials;
            TimePlayed = timePlayed;
            DifficultyLevel = difficultyLevel;
        }

        // Calculates the player's score based on the difficulty level and time played.
        public int CalculateScore()
        {
            int baseScore = 1000 * (int)DifficultyLevel;
            int timePenalty = (int)TimePlayed.TotalSeconds * 10;

            int score = baseScore - timePenalty;

            return score > 0 ? score : 0;
        }

        // Saves the player's statistics to a file.
        public void SavePlayerStats(PlayerStats playerStats)
        {
            string filePath = "playerStats.txt"; // You can change the path as needed

            using (StreamWriter sw = File.AppendText(filePath))
            {
                sw.WriteLine($"{playerStats.Initials},{playerStats.CalculateScore()},{playerStats.TimePlayed},{playerStats.DifficultyLevel}");
            }
        }

        // Compares two PlayerStats objects based on their scores.
        public int CompareTo(PlayerStats other)
        {
            if (other == null)
            {
                return 1;
            }

            return other.CalculateScore().CompareTo(CalculateScore());
        }
    }
}