class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int max = Math.max(n1, n2);
        for (int i = 0; i < max; i++) {
            if (i < n1) res.append(word1.charAt(i));
            if (i < n2) res.append(word2.charAt(i));
        }
        return res.toString();
    }
}
