class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String res="";

        for (int i=words.length-1;i>=0;i--) {
           res=res+words[i]+" ";
        }
        return res.trim();     
    }
}