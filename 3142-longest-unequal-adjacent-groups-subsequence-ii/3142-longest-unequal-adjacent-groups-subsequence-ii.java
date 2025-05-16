class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> seq = new ArrayList<>();
        int n = words.length;

        if (n == 0)
            return seq;
        
        if (n == 1) {
            seq.add(words[0]);
            return seq;
        }

       
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  
        int[] lastIdx = new int[n];
        Arrays.fill(lastIdx, -1);

        int maxLen = 0;  // maximum length of subsequence
        int endIdx = -1;  // index where subsequence ends

        // find the length of subsequence ending at every index
        for (int i = 1; i < n; i++) {
            // at every stage i, we have found the length of longest subsequence ending at j where j < i
            // we need to see if the sequence ending at words[j] can be extended to end at words[i] (i.e. if words[i] can be added to the sequence ending at words[j])

            for (int j = 0; j < i; j++) {
                // groups[j] and groups[i] must be unequal
                if (groups[i] == groups[j])
                    continue;

                // words[j] and words[i] must be equal in length
                if (words[i].length() != words[j].length())
                    continue;

                // hamming distance should be 1
                if (!hamDistCheck(words[i], words[j]))
                    continue;

                // if all conditions satisfy then we can update the length of longest sequence ending at words[i]
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    lastIdx[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIdx = i;
            }
        }

        // now create the sequence
        while (endIdx != -1) {
            seq.add(words[endIdx]);
            endIdx = lastIdx[endIdx];
        }

        Collections.reverse(seq);

        return seq;
    }

    private boolean hamDistCheck(String word1, String word2) {
        int diff = 0;
        int m = word1.length();

        for (int i = 0; i < m; i++) {
            if (word1.charAt(i) != word2.charAt(i))
                diff++;

            if (diff > 1)
                return false;
        }

        return diff == 1;
    }
}