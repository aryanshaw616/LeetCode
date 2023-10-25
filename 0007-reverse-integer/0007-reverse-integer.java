class Solution {
    public int reverse(int x) 
    {   int m=x;
        long r=0;
        while(m!=0)
        {
            int d=m%10;
            r=r*10+d;
            m/=10;
        }
        long f = -(long) Math.pow(2,31);
        long g = (long) Math.pow(2,31)-1;
        if(r>f&&r<g)
        return (int)r;
        else
        return 0;
    }
}