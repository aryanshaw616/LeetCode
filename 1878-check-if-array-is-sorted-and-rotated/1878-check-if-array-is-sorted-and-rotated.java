class Solution {
    public boolean check(int[] nums) {
        int minIdx = 0, min = nums[0];

        // find the x position
        for(int i = 1; i < nums.length; i++){
            if(min >= nums[i] && min < nums[i-1]){
                min = nums[i];
                minIdx = i;
            } else if(min > nums[i]){
                min = nums[i];
                minIdx = i;
            }
        }
        int rotateFactor = nums.length - minIdx;
        int[] numsSorted = new int[nums.length];
        // check whether the rotated array is sorted
        for(int i = 0; i < nums.length; i++){
            numsSorted[(i+rotateFactor) % nums.length] = nums[i];
        }
        for(int i = 1; i < nums.length;i++){
            if(numsSorted[i-1] > numsSorted[i]) return false;
        }
        return true;
    }
}