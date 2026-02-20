class Solution {
        public int check(int x,int y)
        { int s=0;
            for(int i=x;i<=y;i++)
            s+=i;
            return s;
        }
    public int pivotInteger(int n) {
        int x=-1;
        for(int i=1;i<=n;i++)
        {
            if(check(1,i)==check(i,n))
           {
             x=i;
            break;
        }
        }
        return x;
    }
}