class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            nums[i] = -1; 

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
                if (found && nums2[j] > nums1[i]) {
                    nums[i] = nums2[j];
                    break;
                }
            }
        }
        return nums;
    }
}
