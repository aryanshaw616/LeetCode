class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int c=0;
        for(int i=low;i<=high;i++)
        if(isSym(i))
        c++;
        return c;
    }
    static boolean isSym(int n)
    { int l = (n == 0) ? 1 : (int)Math.log10(n) + 1;
    if (l % 2 != 0) return false;
       int f = Integer.parseInt(Integer.toString(n).substring(0, l / 2));
        int k = Integer.parseInt(Integer.toString(n).substring(l / 2));
        return sum(f)==sum(k);
    }
    static int sum(int n)
    {
        int s=0;
        while(n!=0)
        {
            s+=n%10;
            n/=10;
        }
        return s;
    }
}