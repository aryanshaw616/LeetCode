class Tuple implements Comparable<Tuple>{
    int row;
    int col;
    int time;
    int moveCount;

    public Tuple(int row, int col, int time, int moveCount) {
        this.row = row;
        this.col = col;
        this.time = time;
        this.moveCount = moveCount;
    }

    public int compareTo(Tuple t2) {
        return this.time - t2.time;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int dis[][] = new int[n][m];

        for(int i=0; i<n; i++ ){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.add(new Tuple(0, 0, 0, 0));
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!pq.isEmpty()) {

            Tuple t = pq.remove();
            int row = t.row;
            int col = t.col;
            int time = t.time;
            int moves = t.moveCount;

            if(row == n-1 && col == m-1) return time;
            if(time > dis[row][col]) continue;

            for(int i=0; i<4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int newTime = Math.max(time, moveTime[nrow][ncol]);

                    if(moves % 2 == 0) {
                        newTime++;
                    }
                    else {
                        newTime += 2;
                    }

                    if(newTime < dis[nrow][ncol]) {
                        dis[nrow][ncol] = newTime;
                        pq.add(new Tuple(nrow, ncol, newTime, moves+1));
                    }
                } 
             }
        }

        return -1;
    }
}