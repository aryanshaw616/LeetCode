class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int memo[]=new int[cost.length+1];
        Arrays.fill(memo,-1);
        return min(cost ,cost.length, memo);

    }

    static int min(int cost[] ,int n , int memo[])
    {
        if(n<=1)
        return memo[n]=0;
        if(memo[n]!=-1)
        return memo[n];
        else
        {
        int one=cost[n-1]+min(cost,n-1,memo);
        int two=cost[n-2]+min(cost,n-2,memo);
         memo[n]= Math.min(one,two);
    }
    return memo[n];
    }
}