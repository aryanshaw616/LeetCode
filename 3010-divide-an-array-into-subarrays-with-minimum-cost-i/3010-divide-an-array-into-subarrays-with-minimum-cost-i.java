class Solution {
    public int minimumCost(int[] nums) {
        int first_min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= first_min){
                second_min = first_min;
                first_min = nums[i];
            }
            if(nums[i]!=first_min && nums[i] < second_min) second_min = nums[i];
        }
    return nums[0] + first_min + second_min;
    }
}