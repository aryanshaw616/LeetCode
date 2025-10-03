class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>res=new ArrayList<>();
        for(int i=left;i<=right;i++)
        if(self(i) && !Notcontains(i))
        res.add(i);
        return res;
    }
    static List<Integer> dig(int n)
    {
        List<Integer>res=new ArrayList<>();
        while(n!=0)
        {
            
            int d=n%10;
            if(d!=0)
            res.add(d);
            n/=10;
        }
        return res;
    }
    static boolean self(int n)
    {    
        List<Integer>list=dig(n);
        for(int i : list)
        if(n%i!=0) return false;
        return true;
    }
    static boolean Notcontains(int n)
    {
        while(n!=0)
        {
            
            int d=n%10;
            if(d==0)
            return true;
            n/=10;
        }
        return false;
    }
}