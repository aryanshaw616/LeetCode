class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        else
        return bin(x);
    }
    static int bin(int n)
    {
        int l=0,r=n-1,m=0,res=0;
        while(l<=r)
        {
            m=l+(r-l)/2;
            long m2= (long)m*m;
            if(m2==n)
            return m;
            if(m2<n)
            {
                res=m;
                l=m+1;
            }
            else
            r=m-1;
            
        }
        return res;
    }
}