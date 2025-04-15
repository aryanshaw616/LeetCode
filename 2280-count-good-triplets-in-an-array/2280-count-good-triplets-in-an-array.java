class Solution {
    // Function to return the last bit set in the input number
    private int lastOne(int x) {
        return x & (-x);
    }
    
    // Function to update a Fenwick tree with delta at index i
    private void updateFenwickTree(int[] fenwickTree, int index, int delta) {
        for (; index < fenwickTree.length; index += lastOne(index)) {
            fenwickTree[index] += delta;
        }
    }
    
    // Function to get the prefix sum of the Fenwick tree up to index i
    private int getPrefixSum(int[] fenwickTree, int index) {
        int prefixSum = 0;
        for (; index > 0; index -= lastOne(index)) {
            prefixSum += fenwickTree[index];
        }
        return prefixSum;
    }
    
    // Function to get the range sum of the Fenwick tree between startIndex and endIndex
    private int getRangeSum(int[] fenwickTree, int startIndex, int endIndex) {
        return getPrefixSum(fenwickTree, endIndex) - (startIndex == 1 ? 0 : getPrefixSum(fenwickTree, startIndex - 1));
    }
    
    // Main function to find good triplets
    public long goodTriplets(int[] nums1, int[] nums2) {
        // Get the size of the input arrays
        int vectorSize = nums1.length;
        // Create an array to hold the index positions of nums1
        int[] indexPositions = new int[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            indexPositions[nums1[i]] = i;
        }
        // Variable to count the number of good triplets
        long goodTripletCount = 0;
        // Create a Fenwick tree with size n + 5
        int[] fenwickTree = new int[vectorSize + 5];
        // Create an array to hold the number of elements smaller than nums2[i] in nums1 to the right of nums1[i]
        int[] smallerElementsToRight = new int[vectorSize];
        // Loop through nums2 backwards
        for (int i = vectorSize - 1; i >= 0; i--) {
            // Get the index position of nums2[i] in nums1
            int index = indexPositions[nums2[i]];
            // Store the number of elements smaller than nums2[i] in nums1 to the right of nums1[i]
            smallerElementsToRight[nums2[i]] = getRangeSum(fenwickTree, index + 1, vectorSize + 1);
            // Update the Fenwick tree at index j + 1
            updateFenwickTree(fenwickTree, index + 1, 1);
        }
        // Reset the Fenwick tree
        Arrays.fill(fenwickTree, 0);
        // Loop through nums2 forwards
        for (int i = 0; i < vectorSize; i++) {
            // Get the index position of nums2[i] in nums1
            int index = indexPositions[nums2[i]];
            // Count the number of good triplets using the stored values
            long smallerElementsBefore = getPrefixSum(fenwickTree, index);
            goodTripletCount += smallerElementsBefore * smallerElementsToRight[nums2[i]];
            // Update the Fenwick tree at index j + 1
            updateFenwickTree(fenwickTree, index + 1, 1);
        }
        return goodTripletCount;
    }
}