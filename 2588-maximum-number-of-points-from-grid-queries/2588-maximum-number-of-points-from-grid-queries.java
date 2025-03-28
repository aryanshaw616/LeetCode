class Solution {

    int n, m;
    int[][] grid;
    final int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> queries[a] - queries[b]);
        for (int i = 0; i < queries.length; i++) pq.offer(i);
        boolean[][] seen = new boolean[m][n];
        PriorityQueue<int[]> distOne = new PriorityQueue<>((p1,p2) -> grid[p1[0]][p1[1]] - grid[p2[0]][p2[1]]);
        distOne.offer(new int[]{0,0});
        seen[0][0] = true;
        int runningScore = 0;
        int[] ans = new int[queries.length];
        while(!pq.isEmpty()) {
            runningScore += bfs(distOne, queries[pq.peek()], seen);
            ans[pq.poll()] = runningScore;
        }
        return ans;
    }

    private int bfs(PriorityQueue<int[]> distOne, int maxItem, boolean[][] seen){
        int score = 0;
        while(!distOne.isEmpty()){
            int[] gridPoint = distOne.peek();
            if (grid[gridPoint[0]][gridPoint[1]] < maxItem){
                distOne.poll();
                score += 1;
                for (int[] dir : dirs){
                    int[] neighbor = new int[] {gridPoint[0] + dir[0], gridPoint[1] + dir[1]};
                    if (neighbor[0] < m && neighbor[0] >= 0 && neighbor[1] < n && neighbor[1] >= 0 && !seen[neighbor[0]][neighbor[1]]){
                        seen[neighbor[0]][neighbor[1]] = true;
                        distOne.offer(neighbor);
                    }
                }
            }
            else break;
        }
        return score;
    }

}