class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Long> list = new ArrayList<>();
        int n = weights.length;
        for (int i=0; i<n-1; i++) {
            list.add((long)weights[i] + (long)weights[i+1]);
        }
        Collections.sort(list);
        long minSum =0;
        long maxSum =0;
        int len = list.size();
        for (int i=0; i<k-1; i++) {
            minSum += list.get(i);
            maxSum += list.get(len-1-i);
        }
        return maxSum-minSum;
    }
}