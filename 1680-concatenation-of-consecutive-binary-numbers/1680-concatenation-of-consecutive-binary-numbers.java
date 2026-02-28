class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder s = new StringBuilder();
        
        for(int i = 1; i <= n; i++){
            s.append(Integer.toBinaryString(i));
        }

        String sb = s.toString();
        long num = 0;
        int mod = 1000000007;

        for(int i = 0; i < sb.length(); i++){
            num = (num * 2 + (sb.charAt(i) - '0')) % mod;
        }

        return (int) num;
    }
}
