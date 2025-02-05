class Solution {

    public boolean areAlmostEqual(String s1, String s2) {

        int[] s1Miss = new int[2];
        int[] s2Miss = new int[2];
        int s11 = 0;
        int s21 = 0;

        if (s1.length() != s2.length()) {
            return false;
        } else {
            for (int i=0; i< s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    if (s11 > 1 && s21 > 1) {
                        return false;
                    } else {
                        s1Miss[s11++] = s1.charAt(i);
                        s2Miss[s21++] = s2.charAt(i);
                    }
                }
            }
        }

        if (s11 == 0 && s21 == 0) {
            return true;
        }

        if (s1Miss[0] == s2Miss[1] && s1Miss[1] == s2Miss[0]) {
            return true;
        }
        return false;
    }

}