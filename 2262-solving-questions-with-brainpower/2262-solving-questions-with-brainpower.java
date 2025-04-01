class Solution {
    public long mostPoints(int[][] questions) {
        int row = questions.length;
        long[] scoreSum = new long[row];

        for(int i = row-1 ; i>=0 ; i--) {
            int[] value = questions[i];
            int score = value[0];
            int skipTo = value[1];
            long nextScore = (i + skipTo + 1 < row) ? scoreSum[i + skipTo + 1] : 0;
            scoreSum[i] = Math.max(score+nextScore , (i<row-1) ? scoreSum[i + 1] : 0);
        }
        return scoreSum[0];  
    }
}