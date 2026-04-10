class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int min=(int)1e9;
        
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(nums[i]!=nums[j])continue;
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j]&&nums[j]==nums[k]){
                        int res=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        min=Math.min(min,res);
                        break;
                    }
                }
            }
        }
        return min>=(int)1e9?-1:min;
    }
}