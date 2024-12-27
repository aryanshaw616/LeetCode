class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        int max=nums[0];
        int ans=0;
        for(int i=1;i<nums.length;i++){
            ans=Math.max(max+nums[i]-i,ans);
            max=Math.max(max,nums[i]+i);
        }
        return ans;
    }
}// 1 2 5 6 8    