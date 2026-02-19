class Solution {
    public int countBinarySubstrings(String s) {
        int count=0;
        int sg=1;
        int prev=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                sg++;
            }
            else{
                prev=sg;
                sg=1;
            }        
            if(sg<=prev){
                count++;
            }    
        }
        return count;

    }
}