class Solution {
    public int makeTheIntegerZero(int num1, int n2) {
        long n1 = num1;
        for (int x = 1; x < 64; x++) {
            n1 -= n2;
            // case a num1 becomes <= 0
            if (n1 <= 0) return -1;
            
            // case b and c
            if (n1 > 0) {
                int cnt = cntBit(n1);
                // case c bitOfnum1 <= x
                if (cnt <= x) {
                    if (n1 >= x) return x;
                    // if set all operations to 2^0, x still > n1
                    else return -1;
                } 
                // case b, continue iteration, try x + 1
            }
        }
        return -1;
    }
    
    public int cntBit(long num) {
        int cnt = 0;
        for (int i = 0; i < 64; i++) {
            long x = 1;
            x <<= i;
            if ((x & num) != 0) cnt++;
        }
        return cnt;
    }
}