class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List <String> ans = new ArrayList<>();
        //we need a 2d array to map the words, identify words by the index. 
        int n = words2.length;
        int m = words1.length;
        int [] maxFreq = new int [26];
        for(String word : words2){
            int [] temp = new int [26];
            for(char c : word.toCharArray()){
                temp[c-'a']++;
                maxFreq[c-'a'] = Math.max(maxFreq[c-'a'], temp[c-'a']);
            }
        }

       

        for(String word : words1){
             int [] currFreq = new int[26];
            for(char c : word.toCharArray())
                currFreq[c-'a']++;

            if(isUni(maxFreq, currFreq))
                ans.add(word);
            
        }

        return ans;

    }

    private boolean isUni(int[]maxFreq, int [] currFreq){
        for(int i=0; i<26; i++){
            if(currFreq[i] < maxFreq[i])
                return false;
        }
        return true;
    }
}