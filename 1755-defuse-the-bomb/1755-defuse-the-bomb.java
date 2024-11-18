class Solution {
    public int[] decrypt(int[] c, int k) {
        int a[] = new int[c.length];
        if (k == 0) {
            return a;
        }
        for (int i = 0; i < c.length; i++) {
            int s = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    s += c[(i + j) % c.length];
                }
            } else {
                for (int j = 1; j <= Math.abs(k); j++) {
                    s += c[(i - j + c.length) % c.length];
                }
            }
            a[i] = s;
        }
        return a;
    }
}
