class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i : nums)
        map.put(i,map.getOrDefault(i,0)+1);
        int k=nums.length/2;
        for(int i :map.keySet()) 
        if(map.get(i)==k)
        return i;
        return -1;
    }
}