class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        StringBuilder a = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) 
                a.append(s2.charAt(--j));
             else if (j == 0) 
                a.append(s1.charAt(--i));
             else {
                if (f[i][j] == f[i - 1][j]) 
                    a.append(s1.charAt(--i));
                 else if (f[i][j] == f[i][j - 1]) 
                    a.append(s2.charAt(--j));
                 else {
                    a.append(s1.charAt(--i));
                    --j;
                }
            }
        }
        return a.reverse().toString();
    }
}
