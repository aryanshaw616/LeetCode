class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> se = new ArrayList<>();
        se.add(words[0]);
        int x = 0;
        for(int i = 1;i < groups.length;i++){
            if(groups[i] != groups[x]){
                se.add(words[i]);
                x = i;
            }
        }
        return se;
    }
}