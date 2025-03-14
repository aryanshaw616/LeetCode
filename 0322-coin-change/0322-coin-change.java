class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int res = recur(coins, amount, n-1,dp);
        if(res == (int)(1e9)){
            return -1;
        }
        return res;
    }
    public int recur(int coins[], int amount, int index, int dp[][]){
        
        if(index == 0){
            if(amount % coins[index]==0){
                dp[index][amount] = amount / coins[index];
                return amount / coins[index];
            }
            dp[index][amount] = (int)(1e9);
            return (int)(1e9);
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int pick = (int)(1e9);
        if(amount >= coins[index]){
            pick = 1 + recur(coins, amount - coins[index], index, dp);
        }
        int noPick = recur(coins, amount, index-1, dp);
        dp[index][amount] = Math.min(pick, noPick);
        return dp[index][amount];
    }
} 
