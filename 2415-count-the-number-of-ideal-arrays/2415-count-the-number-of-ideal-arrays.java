class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100000;
    long[] factorial = new long[MAX + 1];
    long[] inverseFactorial = new long[MAX + 1];
    int[][] dp = new int[10001][15]; // maxValue ≤ 10^4, and max length ≤ 14

    // Precomputes factorials and their modular inverses
    void precomputeFactorials(int n) {
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        inverseFactorial[n] = modInverse(factorial[n]);
        for (int i = n - 1; i >= 0; i--) {
            inverseFactorial[i] = (inverseFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    // Fast modular exponentiation
    long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    // Modular inverse using Fermat's little theorem
    long modInverse(long x) {
        return power(x, MOD - 2);
    }

    // Computes nCr % MOD
    long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return factorial[n] * inverseFactorial[r] % MOD * inverseFactorial[n - r] % MOD;
    }

    public int idealArrays(int n, int maxValue) {
        int maxLen = Math.min(n, 14);  // Because 2^14 > 10000 (maxValue limit)
        precomputeFactorials(n);

        // dp[i][len] = number of sequences ending in i with length len
        for (int i = 1; i <= maxValue; i++) {
            dp[i][1] = 1;
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxValue; i++) {
                if (dp[i][len - 1] == 0) continue;
                for (int multiple = 2 * i; multiple <= maxValue; multiple += i) {
                    dp[multiple][len] = (dp[multiple][len] + dp[i][len - 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int len = 1; len <= maxLen; len++) {
                if (dp[i][len] > 0) {
                    long ways = nCr(n - 1, len - 1);
                    result = (result + ways * dp[i][len]) % MOD;
                }
            }
        }

        return (int) result;
    }
}