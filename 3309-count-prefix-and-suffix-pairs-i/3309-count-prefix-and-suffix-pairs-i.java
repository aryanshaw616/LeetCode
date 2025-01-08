class Solution {
    public static boolean isPrefixandSuffix(String str1, String str2) {
        boolean found = true;
        if (str1.length() > str2.length()) {
            return false;
        } 
        else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)){
                    return false;
                }
            }
            int cnt = 0;
            for(int j = str1.length()-1;j>=0;j--){
                if(str1.charAt(j) != str2.charAt(str2.length()-1-cnt)){
                    return false;
                }
                cnt++;
            }
        }
        return found;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int v = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                v += (isPrefixandSuffix(words[i], words[j])) ? 1 : 0;
            }
        }
        return v;
    }
}