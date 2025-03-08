class Solution {
    public int minimumRecolors(String blocks, int k) {
        int noW = 0;
        int min = Integer.MAX_VALUE;
        
        // Count 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') noW++;
        }
        
        min = Math.min(noW, min);
        
        // Sliding window technique
        int i = 1;
        while (i <= blocks.length() - k) {
            if (blocks.charAt(i - 1) == 'W') noW--;  // Remove outgoing element
            if (blocks.charAt(i + k - 1) == 'W') noW++;  // Add incoming element
            min = Math.min(noW, min);
            i++;
        }

        return min;
    }
}