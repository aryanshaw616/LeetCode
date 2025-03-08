class Solution {
    public int rob(int[] nums) {
        int memo[]=new int[nums.length+1];
        Arrays.fill(memo,-1);
        return house(nums,nums.length-1,memo);
    }
    static int house(int nums[],int n , int memo[])
    {
        if(n<0)
        return 0;
        if(memo[n]!=-1)
        return memo[n];
        else
        {
            int pick=nums[n] + house(nums,n-2,memo);
            int unpick=0+house(nums,n-1,memo);
        
        memo[n]=Math.max(pick,unpick);
        }
        return memo[n];
    }
}