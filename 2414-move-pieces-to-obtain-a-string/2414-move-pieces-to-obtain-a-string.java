class Solution {
    public boolean canChange(String start, String target) {
        String onlyDirsStart = start.replace("_", "");
        String onlyDirsTarget = target.replace("_", "");
        if (!onlyDirsStart.equals(onlyDirsTarget)) {
            return false;
        }
        int balance = 0;
        for (int i = 0; i < start.length(); i++) {
            if (target.charAt(i) == 'L') {
                balance++;
            }
            if (start.charAt(i) == 'L') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        balance = 0;
        for (int i = start.length() - 1; i >= 0; i--) {
            if (target.charAt(i) == 'R') {
                balance++;
            }
            if (start.charAt(i) == 'R') {
                balance--;
            }    
            if(balance < 0) {
                return false;
            }
        }
        return true;
    }
}