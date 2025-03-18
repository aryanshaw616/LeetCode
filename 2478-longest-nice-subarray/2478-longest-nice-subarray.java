class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 0, left = 0, bitwiseAND = 0;

        for(int right = 0; right < nums.length; right++){
            while((bitwiseAND & nums[right]) != 0){
                bitwiseAND ^= nums[left];
                left++;
            }
            bitwiseAND |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}