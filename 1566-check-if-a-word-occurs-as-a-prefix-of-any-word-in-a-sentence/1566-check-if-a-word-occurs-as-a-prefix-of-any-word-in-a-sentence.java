class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (isPrefix(words[i], searchWord))
                return i + 1;
        }

        return -1;
    }

    private boolean isPrefix(String word, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (i >= word.length())
                return false;

            if (searchWord.charAt(i) != word.charAt(i))
                return false;
        }

        return true;
    }
}