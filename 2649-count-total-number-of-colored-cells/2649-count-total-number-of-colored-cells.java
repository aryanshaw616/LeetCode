class Solution {
    public long coloredCells(int n) {
        long result = 0;
        result += 2 * n - 1;
        n--;
        while(n > 0){
            result += 2*(2*n-1);
            n -= 1;
        }
        return result;
    }
}