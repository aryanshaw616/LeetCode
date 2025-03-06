class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int arr[]=new int[2];
        int c=0,s=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int row[]:grid)
        for(int i:row)
        map.put(i,map.getOrDefault(i,0)+1);
        for(int i :map.keySet())
        {
            s+=i;
            if(map.get(i)==2)
            arr[0]=i;
        }
        c=(n * n * (n * n + 1)) / 2;
        arr[1]=c-s;
        return arr;
    }
}