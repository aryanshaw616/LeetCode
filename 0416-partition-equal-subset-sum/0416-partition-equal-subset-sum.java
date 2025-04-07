class Solution {
    Boolean dp[][];
    int half = 0;
    private boolean f(int nums[],int i,int sum1){
        if(sum1 > half){
            return false;
        }
        if(i == nums.length){
            return sum1 == half;
        }
        if(dp[i][sum1] != null){
            return dp[i][sum1];
        }
        return dp[i][sum1] = f(nums,i+1,sum1 + nums[i]) || f(nums,i+1,sum1);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a:nums){
            sum += a;
        }
        if(sum % 2 != 0){
            return false;
        }
        half = sum/2;
        dp = new Boolean[nums.length][sum/2 + 1];
        return f(nums,0,0);
    }
}
