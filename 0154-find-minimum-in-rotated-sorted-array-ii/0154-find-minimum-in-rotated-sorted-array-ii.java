class Solution {
    public int findMin(int[] nums) {
      int k = Arrays.stream(nums).min().getAsInt();
        return k;
    }
}