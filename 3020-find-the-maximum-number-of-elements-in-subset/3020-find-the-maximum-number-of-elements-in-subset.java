class Solution {
    static TreeMap<Integer,Integer>map;
    public int maximumLength(int[] nums) {
        map=new TreeMap<>();
        
        for(int a:nums){
              map.put(a,map.getOrDefault(a,0)+1);
        }
         int max = 1;
        for(int a:map.keySet()){
            int ans=0;
           
            if(a==1){
               ans=map.get(a)%2==0?map.get(a)-1:map.get(a);
               max=Math.max(max,ans);
               continue;
            }
      while(map.get(a)>=2&&map.containsKey(a*a)){
         long nxt = 1L * a * a;
          if(nxt > Integer.MAX_VALUE || !map.containsKey((int)nxt))
          break;
          ans+=2;
 
         a = (int)nxt;
             
      }
      if(map.get(a)>=1){
        ans+=1;
      }
      else{
        ans-=1;
      }
      max=Math.max(max,ans);
   
        }
           return max;
    }
}