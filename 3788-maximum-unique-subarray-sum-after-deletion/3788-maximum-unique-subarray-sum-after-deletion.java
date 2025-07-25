class Solution {
    public int maxSum(int[] nums) {
        Set<Integer>set=new TreeSet<>();
        int s=0;
        for(int i:nums)
        if(i>0)
        set.add(i);
        if(set.size()==0)
        return Arrays.stream(nums).max().getAsInt();
        else
        {
           for(int i:set)
           s+=i;
           return s;
        }
    }
}