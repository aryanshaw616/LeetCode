class Solution {
    public int sumOfUnique(int[] nums) { 
        int s=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i : nums)
        map.put(i,map.getOrDefault(i,0)+1);
        for(int i :map.keySet())
        if(map.get(i)==1)
        s+=i;
        return s;
    }
}