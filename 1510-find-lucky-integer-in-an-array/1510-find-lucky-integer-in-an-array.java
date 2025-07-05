class Solution {
    public int findLucky(int[] arr) {
        int r=-1;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:arr)
        map.put(i,map.getOrDefault(i,0)+1);
        for(int i:arr)
        if(i==map.get(i))
        r=Math.max(r,i);
        return r;
    }
}