class Solution {
    public boolean canConstruct(String s, int k) {
        int[] a = new int[26];
        char[] arr = s.toCharArray();
        for (char c: arr) {
            int pos = (int)c - (int)'a';
            a[pos]++;
        }
        int singles = 0;
        int pairs = 0;
        for (int next: a) {
            if (next % 2 == 0) {
                pairs += next/2;
            } else {
                singles++;
                next--;
                pairs += next/2;
            }
        }
        if (singles > k) {
            return false;
        }
        if (singles == k) {
            return true;
        }
        k -= singles;
        if (pairs >= k) {
            return true;
        }
        return pairs*2 >= k;
    }
}