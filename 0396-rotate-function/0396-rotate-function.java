class Solution {
    public int maxRotateFunction(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
         int sum = 0, F0 = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums [i];
            F0 += i * nums [i];
        }
        int dp [] = new int [nums.length];
        dp [0] = F0;
        max = dp [0];
        for (int i = 1; i < nums.length; i++) {
            dp [i] = dp [i-1] + sum - nums.length * nums [nums.length - i];
            max = Math.max (max, dp [i]);
        }
        return max;
    }
}