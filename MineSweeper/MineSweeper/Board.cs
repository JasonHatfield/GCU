using System;

namespace Minesweeper
{
    public class Board
    {
        public int Size { get; }
        public int NumMines { get; }
        public int Difficulty { get; private set; }

        private readonly Cell[,] cells;

        public Board(int size, int numMines, int difficulty)
        {
            Size = size;
            NumMines = numMines;
            Difficulty = difficulty;
            cells = new Cell[size, size];
            InitializeBoard();
        }

        private void InitializeBoard()
        {
            for (int i = 0; i < Size; i++)
            {
                for (int j = 0; j < Size; j++)
                {
                    cells[i, j] = new Cell();
                }
            }
        }

        public void PlaceMinesAfterFirstClick(int excludeX, int excludeY)
        {
            var rand = new Random();
            int numPlacedMines = 0;
            while (numPlacedMines < NumMines)
            {
                int x = rand.Next(0, Size);
                int y = rand.Next(0, Size);

                if (!cells[x, y].HasMine && (x != excludeX || y != excludeY))
                {
                    cells[x, y].HasMine = true;
                    numPlacedMines++;
                }
            }
            CalculateAdjacentMines();
        }

        public Cell GetCell(int x, int y)
        {
            if (x < 0 || x >= Size || y < 0 || y >= Size)
            {
                return null;
            }
            return cells[x, y];
        }

        private void CalculateAdjacentMines()
        {
            for (int i = 0; i < Size; i++)
            {
                for (int j = 0; j < Size; j++)
                {
                    if (!cells[i, j].HasMine)
                    {
                        cells[i, j].NumAdjacentMines = CountAdjacentMines(i, j);
                    }
                }
            }
        }

        private int CountAdjacentMines(int i, int j)
        {
            int adjacentMines = 0;
            for (int x = -1; x <= 1; x++)
            {
                for (int y = -1; y <= 1; y++)
                {
                    int xi = i + x;
                    int yj = j + y;
                    if (xi >= 0 && xi < Size && yj >= 0 && yj < Size && cells[xi, yj].HasMine)
                    {
                        adjacentMines++;
                    }
                }
            }
            return adjacentMines;
        }
    }
}