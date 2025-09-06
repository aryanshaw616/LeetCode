class Solution {
    public long minOperations(int[][] queries) {
        long ans=0;
        for(int q[]:queries)
            {
                int l=q[0],r=q[1];
                long s=0;
                for(int i=1;i<=15;i++)
                    {
                        long low=(long)Math.pow(4,i-1);
                        long high=(long)Math.pow(4,i)-1;
                        long a=Math.max(l,low);
                        long b=Math.min(r,high);
                        if(a<=b)
                            s+=i*(b-a+1);
                    }
                ans+=(s+1)/2;
            }
        return ans;
    }
}