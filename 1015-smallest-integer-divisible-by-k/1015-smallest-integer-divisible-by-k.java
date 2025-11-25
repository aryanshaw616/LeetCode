class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0) return -1;
        int count=1,n=1;
        while(n%k!=0){
            n=(n*10+1)%k;
            count++;
        }
        return count;
    }
}