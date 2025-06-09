class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        
        while (k > 0) {
            int steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }
        
        return current;
    }
    
    private int countSteps(int n, long cur, long next) {
        int steps = 0;
        while (cur <= n) {
            steps += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return steps;
    }
}