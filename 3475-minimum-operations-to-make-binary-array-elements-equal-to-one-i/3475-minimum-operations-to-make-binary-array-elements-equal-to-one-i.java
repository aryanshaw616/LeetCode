class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1) continue;
            nums[i] = flip(nums[i]);
            nums[i + 1] = flip(nums[i + 1]);
            nums[i + 2] = flip(nums[i + 2]);
            count++;
        }
        if (nums[nums.length - 1]!= 1 || nums[nums.length - 2]!= 1) return -1;
        return count;
    }

    public static int flip(int i) {
        return i == 0 ? 1 : 0;
    }
}