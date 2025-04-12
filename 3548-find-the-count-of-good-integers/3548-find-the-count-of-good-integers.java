class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> parentSet = new HashSet<>();
        int subRangeBeg = (int) Math.pow(10, (n - 1) / 2);
        int parity = n % 2;

        for (int i = subRangeBeg; i < subRangeBeg * 10; i++) {
            String firstHalf = String.valueOf(i);
            String secondHalf = new StringBuilder(firstHalf).reverse().toString();
            String palinString = firstHalf + secondHalf.substring(parity);

            long palindrome = Long.parseLong(palinString);
            if (palindrome % k == 0) {
                char[] chars = palinString.toCharArray();
                Arrays.sort(chars);
                parentSet.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long resultCount = 0;

        for (String ele : parentSet) {
            int[] count = new int[10];
            for (char c : ele.toCharArray()) {
                count[c - '0']++;
            }

            long currentCount = 0;
            for (int d = 1; d <= 9; d++) {
                if (count[d] == 0) continue;
                count[d]--;

                long perm = factorial[n - 1];
                for (int x : count) {
                    if (x > 1) perm /= factorial[x];
                }

                currentCount += perm;
                count[d]++;
            }

            resultCount += currentCount;
        }

        return resultCount;
    }
}