class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = (start ^ goal);
        int c=0;
        while(xor!=0)
        {
            if((xor&1)==1) c++;
            xor>>=1;
        }
        return c;
    }
}