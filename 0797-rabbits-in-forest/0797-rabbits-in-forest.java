class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        int[] count = new int[1000 + 1];

        int res = 0;

        for (int i = 0; i < n; i++) {
            int ans = answers[i] + 1;
            count[ans]++;

            if (count[ans] == ans) {
                res += ans;
                count[ans] = 0; 
            }
        }

        for (int i = 1; i <= 1000; i++) {
            if (count[i] > 0) res += i;
        }

        return res;
    }
}




// 2 2 2 2 2 