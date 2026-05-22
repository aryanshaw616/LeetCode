class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the target is found
            if (nums[mid] == target) {
                return mid;
            }

            // Determine if the left side is sorted
            if (nums[start] <= nums[mid]) {
                // Target is in the sorted left half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1; // search in the left half
                } else {
                    start = mid + 1; // search in the right half
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1; // search in the right half
                } else {
                    end = mid - 1; // search in the left half
                }
            }
        }

        return -1; // Target not found
    }
}