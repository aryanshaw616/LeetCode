class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
               int curr = nums[i] * nums[j];
               ans += 8 * map.getOrDefault(curr, 0);
               map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
        }
        return ans;
    }
}