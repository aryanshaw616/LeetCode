class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // binary search, range 1 - max
        int l = 1, r = -1;
        for (int val : nums)
            r = Math.max(r, val); // set r to max of nums
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (min(nums, mid) > maxOperations)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    int min(int[] nums, int mid) {
        int res = 0;
        for (int val : nums)
            if (val > mid)
                res += (val - 1) / mid;
        return res;
    }
}