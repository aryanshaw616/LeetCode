class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long totalComb= ((n-1)*(n))/2;
        long goodCombination=0;
        Map<Long,Long> map=new HashMap<>();
        for(int i=0;i<n;i++){
            Long val=(long)nums[i]-i;
            if(map.containsKey(val)){
                goodCombination+=map.get(val);
            }
            map.put(val,map.getOrDefault(val,(long)0)+1);
        }
        return totalComb-goodCombination;
    }
}