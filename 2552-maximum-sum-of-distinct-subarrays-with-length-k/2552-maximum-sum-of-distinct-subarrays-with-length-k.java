class Solution {
    public long maximumSubarraySum(int[] a, int k) {
        if(k == 1){
            int m = 0;
            for(int n: a) m = Math.max(m, n);
            return m;
        }

        HashSet<Integer> s = new HashSet<>();
        int l = 0, r = 1;
        long sum = a[0], maxSum = 0;
        s.add(a[0]);

        while(r < a.length){
            if(s.contains(a[r])){
                s.remove(a[l]);
                sum -= a[l++];
            } else {
                s.add(a[r]);
                sum += a[r];
                if(r - l == k - 1){
                    maxSum = Math.max(sum, maxSum);
                    s.remove(a[l]);
                    sum -= a[l++];
                    r++;
                } else {
                    r++;
                }
            }
        }
        return maxSum;
    }
}
