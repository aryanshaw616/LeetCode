class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        int maxOpened = 0;
        int minOpened = 0;
        for (int i = 0; i < s.length(); i++){
            if (locked.charAt(i) == '1') {
                minOpened += (s.charAt(i) == '(') ? 1 : -1;
                maxOpened += (s.charAt(i) == '(') ? 1 : -1;
            }
            else {
                maxOpened++;
                if (minOpened > 0) minOpened--;
                else minOpened++;
            }
            if (maxOpened < 0) return false; 
            if (minOpened == -1){
                if (maxOpened > 0) minOpened = (i % 2 == 0) ? 1 : 0;
                else return false;
            }
        }
        return minOpened == 0;
    }
}