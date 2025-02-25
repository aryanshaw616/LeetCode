class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1;
        int sum = 0, result = 0;
        int MOD = 1000000007;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return result;
    }
}