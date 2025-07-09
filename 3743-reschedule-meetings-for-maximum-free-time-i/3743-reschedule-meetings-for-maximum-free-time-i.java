class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime){
        /*
        n events create n + 1 gaps - some of which may be 0
        (n gaps preceding the events and 1 gap after the final event).

        We can coalesce up to k + 1 contiguous events by rearranging k events.

        The solution then maps to the largest sum of k contiguous gaps.
         */
        int[] gaps = getGaps(eventTime, startTime, endTime);
        return getMaxKSum(k, gaps);
    }


    private static int[] getGaps(
            int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        gaps[0] = startTime[0]; // gap before first event
        gaps[n] = eventTime - endTime[n-1]; // gap after final event
        for(int i = 1; i < n; i++) {
            // gap between events
            gaps[i] = startTime[i] - endTime[i-1];
        }
        return gaps;
    }

    private static int getMaxKSum(int k, int[] gaps) {
        int curr = 0;
        int max;
        int windowSize = Math.min(k + 1, gaps.length);

        // get the sum of first window
        for (int i = 0; i < windowSize; i++) {
            curr += gaps[i];
        }
        max = curr;

        // compare subsequent windows
        for(int i = windowSize; i < gaps.length; i++){
            // remove item leaving window and add item entering window
            curr += (gaps[i] - gaps[i - windowSize]);
            max = Math.max(max, curr);
        }
        return max;
    }
}