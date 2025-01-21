class Solution {
    public long gridGame(int[][] grid) {
        // get the length of the rows
        int N = grid[0].length;

        // calculate the prefix sum for the first row and second row
        long[] firstRowPrefixSum = new long[N];
        firstRowPrefixSum[0] = grid[0][0];
        long[] secondRowPrefixSum = new long[N];
        secondRowPrefixSum[0] = grid[1][0];

        for (int i = 1; i < N; i++) {
            firstRowPrefixSum[i] = grid[0][i] + firstRowPrefixSum[i - 1];
            secondRowPrefixSum[i] = grid[1][i] + secondRowPrefixSum[i - 1];
        }

        long res = Long.MAX_VALUE;
        // loop through the length of rows
        for (int i = 0; i < N; i++) {
            // this is the trick to solve this problem 
            // calculate the top sum the second robot can make if the first 
            // robot tuns down in index i
            long firstRow = firstRowPrefixSum[N - 1] - firstRowPrefixSum[i];
            // calculate the bottom sum the second robot can make if the first 
            // robot tuns down in index i
            long secondRow;
            if (i > 0) {
                secondRow = secondRowPrefixSum[i - 1];
            } else {
                secondRow = 0;
            }
            // take the max of it because the second robot want to 
            // maximize the result 
            long secondRobot = Math.max(firstRow, secondRow);

            // for the result take the minimum as the first robot wants to 
            // minimize the res;
            res = Math.min(res, secondRobot);
        }

        return res;

    }
}