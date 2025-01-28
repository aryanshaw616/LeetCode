class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int[] temp = {0};
                    whatTheFish(i, j, visited, grid, temp);
                    System.out.println(temp[0]);
                    ans = Math.max(ans, temp[0]);
                }
            }
        }
        return ans;
    }

    public void whatTheFish(int i, int j, boolean[][] visited, int[][] grid, int[] temp) {
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        if (grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        temp[0] += grid[i][j];
        visited[i][j] = true;
        for (int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length) {
                whatTheFish(newI, newJ, visited, grid, temp);
            }
        }
    }
}