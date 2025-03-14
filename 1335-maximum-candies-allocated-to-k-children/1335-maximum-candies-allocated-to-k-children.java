class Solution {
    public int maximumCandies(int[] c, long k) {
        long s = 0;
        int m = 0;
        for (int x : c) {
            s += x;
            m = Math.max(m, x);
        }
        if (s < k) return 0;

        int l = 1, r = m, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canDistribute(c, k, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private boolean canDistribute(int[] c, long k, int x) {
        long cnt = 0;
        for (int v : c) cnt += v / x;
        return cnt >= k;
    }
}