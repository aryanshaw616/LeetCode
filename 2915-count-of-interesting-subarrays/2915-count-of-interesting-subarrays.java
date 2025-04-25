class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> mods = new HashMap<>();
        mods.put(0, 1L);

        long prefix = 0;
        long res = 0;

        for(int num: nums){
            if(num % modulo == k){
                prefix++;
            }

            int currMod = (int)(prefix % modulo);
            int targetMod = (currMod - k + modulo) % modulo;

            res += mods.getOrDefault(targetMod, 0L);

            mods.put(currMod, mods.getOrDefault(currMod, 0L) + 1);
        }
        return res;
    }
}