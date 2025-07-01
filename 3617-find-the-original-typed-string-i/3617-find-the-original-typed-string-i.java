class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int n1 = word.length();//dkhndhfjifoji
        
        for (int i = 0; i < n1; i++) {
            char currChar = word.charAt(i);
            int j = i;
            
            while (j < n1 && word.charAt(j) == currChar) {
                j++;
            }
            
            int len = j - i;
            if (len > 1) {
                count += (len - 1);
            }
            //fhfduhdfhnjfg
            i = j - 1; // hfhth
        }
        
        return count;
    }
}
