class Solution {
    public int findFinalValue(int[] nums, int original) {
        List<Integer>list=new ArrayList<>();
        for(int i : nums)
        list.add(i);
        while(list.contains(original))
        original*=2;
        return original;
    }
}