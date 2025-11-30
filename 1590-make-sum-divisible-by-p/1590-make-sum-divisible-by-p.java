class Solution {
    public int minSubarray(int[] nums, int p) {
      int n  = nums.length;
      int ans = 0;
      for(int i=0;i<n;i++){
          ans = (ans+nums[i])%p;
      }   
      if( ans == 0) return 0;
      int res =n;
      int sum =0;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0,-1);
      for(int i=0;i<n;i++){
          sum = (sum+ nums[i]) %p;
         
          int mod = ( sum-ans+p) %p;
           map.put(sum,i);
          if(map.containsKey(mod)){
              res = Math.min( res, i-map.get(mod));
          }
      }
      return res < n  ? res: -1;
    }
}