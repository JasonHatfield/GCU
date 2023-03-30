namespace Minesweeper
{
    public class Cell
    {
        public bool HasMine { get; set; }
        public bool HasFlag { get; set; }
        public bool IsRevealed { get; set; }
        public bool IsOpen { get; set; }
        public bool HasQuestionMark { get; set; }
        public int NumAdjacentMines { get; set; }

        public Cell()
        {
        }
    }
}