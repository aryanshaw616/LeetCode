class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int qn = queries.length;
        int[] prefSum = new int[n+1];
        for(int i=1;i<=n;i++) {
            prefSum[i] = prefSum[i-1] + (isVowelWord(words[i-1]) ? 1 : 0);
        }
        int[] ans = new int[qn];
        for(int i=0;i<qn;i++) {
            ans[i] = prefSum[queries[i][1]+1] - prefSum[queries[i][0]];
        }
        return ans;
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
    public boolean isVowelWord(String s) {
        if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))) return true;
        return false;
    }
}