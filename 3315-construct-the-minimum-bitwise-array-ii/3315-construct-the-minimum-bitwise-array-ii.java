class Solution {
    public int[] minBitwiseArray(List<Integer> nums1) {
        int[] ans = new int[nums1.size()];
        int n=nums1.size();
        for(int i=0;i<n;i++)
           { int num = nums1.get(i);
            int m=Integer.MAX_VALUE;
            boolean f=false;
            for(int b=0;b<=30;b++)
            {
                if(((num>>b) & 1)==1)
                {
                    int c=num & ~(1<<b);
                    if(c<0) continue;
                    if((c|(c+1) )==num)
                    {
                        if(c<m){
                        m=c;
                        f=true;
                    }
                }
            }
         }
            ans[i]=f?m:-1;
           }
        
        return ans;
    }
}
     