class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        
        // minSoFar[r] stores the minimum prefix sum with index % k == r
        long[] minSoFar = new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE / 2); // Avoid overflow
        
        // Initialize: prefix sum at index -1 is 0, and (-1) % k = (k-1) % k
        minSoFar[(k - 1) % k] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = i % k;
            
            // Maximum subarray ending at i with length divisible by k
            // = prefixSum - minSoFar[currentMod]
            maxSum = Math.max(maxSum, prefixSum - minSoFar[currentMod]);
            
            // Update minimum prefix sum for current modulo class
            minSoFar[currentMod] = Math.min(minSoFar[currentMod], prefixSum);
        }
        
        return maxSum;
    }
}