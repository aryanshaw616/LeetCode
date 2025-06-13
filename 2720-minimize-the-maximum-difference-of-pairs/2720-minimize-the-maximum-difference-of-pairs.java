class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;

        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n-1] - nums[0];
        
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isValidPair(nums,mid,p)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean isValidPair(int[] nums,int mid,int p){
        int i = 0;
        int pair = 0;
        while(i < nums.length - 1){
            if(nums[i+1] - nums[i] <= mid){
                pair++;
                i += 2; 
            }else{
                i++;
            }
        }

        return pair >= p;
    }
}