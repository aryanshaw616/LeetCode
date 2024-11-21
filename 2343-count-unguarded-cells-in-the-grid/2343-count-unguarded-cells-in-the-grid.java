class Solution {
    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        // Grid to track the state of each cell: -1 (unvisited), 0 (wall), 1 (guard), 2 (guarded)
        int[][] grid = new int[rows][cols];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }
        
        // Total cells in the grid
        int totalCells = rows * cols; 
        int blockedCells = 0;

        // Mark guard positions
        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];
            blockedCells++;
            grid[r][c] = 1;
        }

        // Mark wall positions
        for (int[] wall : walls) {
            int r = wall[0], c = wall[1];
            blockedCells++;
            grid[r][c] = 0;
        }

        // Process each guard's visibility in 4 directions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    blockedCells += markRight(rows, cols, r, c + 1, grid);
                    blockedCells += markLeft(rows, cols, r, c - 1, grid);
                    blockedCells += markDown(rows, cols, r + 1, c, grid);
                    blockedCells += markUp(rows, cols, r - 1, c, grid);
                }
            }
        }

        return totalCells - blockedCells;
    }

    // Mark cells in the right direction guarded by a guard
    public int markRight(int rows, int cols, int r, int c, int[][] grid) {
        if (c == cols || grid[r][c] == 0 || grid[r][c] == 1) return 0; // Stop on wall or guard
        if (grid[r][c] == 2) return markRight(rows, cols, r, c + 1, grid); // Skip already guarded
        grid[r][c] = 2; // Mark as guarded
        return 1 + markRight(rows, cols, r, c + 1, grid);
    }

    // Mark cells in the left direction guarded by a guard
    public int markLeft(int rows, int cols, int r, int c, int[][] grid) {
        if (c == -1 || grid[r][c] == 0 || grid[r][c] == 1) return 0;
        if (grid[r][c] == 2) return markLeft(rows, cols, r, c - 1, grid);
        grid[r][c] = 2;
        return 1 + markLeft(rows, cols, r, c - 1, grid);
    }

    // Mark cells in the downward direction guarded by a guard
    public int markDown(int rows, int cols, int r, int c, int[][] grid) {
        if (r == rows || grid[r][c] == 0 || grid[r][c] == 1) return 0;
        if (grid[r][c] == 2) return markDown(rows, cols, r + 1, c, grid);
        grid[r][c] = 2;
        return 1 + markDown(rows, cols, r + 1, c, grid);
    }

    // Mark cells in the upward direction guarded by a guard
    public int markUp(int rows, int cols, int r, int c, int[][] grid) {
        if (r == -1 || grid[r][c] == 0 || grid[r][c] == 1) return 0;
        if (grid[r][c] == 2) return markUp(rows, cols, r - 1, c, grid);
        grid[r][c] = 2;
        return 1 + markUp(rows, cols, r - 1, c, grid);
    }
}
