class Solution {
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int maxFreq = 0; 
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
            maxFreq = Math.max(maxFreq, hs.get(sum));
        }

        int count = 0;  
        for (int freq : hs.values()) {
            if (freq == maxFreq) {
                count++;
            }
        }

        return count;
    }
}