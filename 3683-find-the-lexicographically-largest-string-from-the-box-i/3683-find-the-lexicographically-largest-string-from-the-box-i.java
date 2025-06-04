class Solution {
    public void func(int i, int j, String word, String[] str) {
        String s = word.substring(i, j);
        if (str[0].equals("")) {
            str[0] = s;
            return;
        }
        if (str[0].compareTo(s) < 0) {
            str[0] = s;
        }
    }

    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        int k = n - numFriends + 1;
        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) > ch) {
                ch = word.charAt(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch) {
                list.add(i);
            }
        }

        String[] str = new String[]{""}; // ✅ Fix: Initialize with empty string

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != ch) continue;
            int j = Math.min(n, i + k);
            func(i, j, word, str);
        }

        return str[0];
    }
}