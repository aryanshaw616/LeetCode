class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int result = 0;

        if (num1Len % 2 == 1) {
            for (int i = 0; i < num2Len; i++) {
                result ^= nums2[i];
            }
        }

        if (num2Len % 2 == 1) {
            for (int i = 0; i < num1Len; i++) {
                result ^= nums1[i];
            }
        }
        return result;
    }
}