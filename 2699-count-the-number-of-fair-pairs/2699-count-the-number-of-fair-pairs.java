class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return smaller(nums, upper) - smaller(nums, lower - 1);     
    }
    private long smaller(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        long result = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= value) {
                result += (r - l);
                l++;   
            } else {    
                r--;
            }
        }
        return result;
    }
}