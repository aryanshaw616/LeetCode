class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int diff=Integer.MIN_VALUE;
        for(int i=1;i<arrays.size();i++){
            List<Integer>l=arrays.get(i);
            int a=l.get(0);
            int b=l.get(l.size()-1);
            diff=Math.max(diff,Math.abs(max-a));
            diff=Math.max(diff,Math.abs(b-min));
            max=Math.max(b,max);
            min=Math.min(min,a);
        }
        return diff;
    }
}