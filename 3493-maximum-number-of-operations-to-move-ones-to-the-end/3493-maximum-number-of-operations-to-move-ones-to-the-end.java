class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int onesCount =0;
        int ans = 0;
        int i=0;
        int prevBit=-1;
        
        while(i<n){
            int bit = s.charAt(i)-'0';
            onesCount+= bit;
            if(bit==0 && prevBit==1){
                ans+=onesCount;
            }
            prevBit = bit;
            i++;
        }
        return ans;
    }
}