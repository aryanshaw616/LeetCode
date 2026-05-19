class Solution {
    public int getCommon(int[] a1, int[] a2) {
        HashMap <Integer,Integer> map1= new HashMap<>();
        for(int i=0;i<a1.length;i++)
        {
            if(map1.containsKey(a1[i]))
            map1.put(a1[i],map1.get(a1[i]+1));
            else
            map1.put(a1[i],1);
        }
        int min=a2[a2.length-1],f=0;
        for(int i=0;i<a2.length;i++)
        {   
                if(map1.containsKey(a2[i]))
                {
                    min = Math.min(min,a2[i]);
                    f++;
                }
        }
       if(f>0)
       return min;
       else
       return -1;
    }
}