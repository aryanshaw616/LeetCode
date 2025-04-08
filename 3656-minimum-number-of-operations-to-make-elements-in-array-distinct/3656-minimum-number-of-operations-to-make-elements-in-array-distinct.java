class Solution {
    public int minimumOperations(int[] nums) {
        int firstIndex = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=nums.length-1; i>=0; i--) {
            if(!set.add(nums[i])) {
                firstIndex = i;
                break;
            }
        }
        if(set.size()==nums.length) return 0;
        return (firstIndex+3)/3;
    }
}