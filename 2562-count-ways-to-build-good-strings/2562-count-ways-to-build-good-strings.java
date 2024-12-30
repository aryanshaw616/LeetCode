class Solution {
   public static double  m=1e9+7;
    public static int solve(int low,int high,int z,int o,int y,int[] dp){
        if(high<y){
            return 0;
        }
        int d=0;
        if(dp[y]!=-1){
            return dp[y];
        }
        if(low<=y && y<=high){
           d=1;
        }
        int append_z=solve(low,high,z,o,y+z,dp);
        int append_o=solve(low,high,z,o,y+o,dp);
        return dp[y]=(int)((d+append_z+append_o)%m);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int z=zero;
        int o=one;
        int[] dp=new int[(int)1e5+1];
        Arrays.fill(dp,-1);
        return solve(low,high,z,o,0,dp);
    }
}