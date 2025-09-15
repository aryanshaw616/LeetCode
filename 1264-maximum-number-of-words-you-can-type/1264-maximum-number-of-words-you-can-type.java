
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int broken = 0;
        String[] words = text.split(" ");
        
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (brokenLetters.indexOf(ch) != -1) { // if broken letter found
                    broken++;
                    break; // no need to check rest of the word
                }
            }
        }
        
        return words.length - broken; 
    }
}