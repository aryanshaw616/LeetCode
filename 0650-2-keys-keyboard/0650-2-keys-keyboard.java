class Solution {
    public int minSteps(int n) {
        int l=1;
        int temp=1;
        int count=0;
        while(l!=n){
            if((n-l)%l==0){
                temp=l;
                l=l+temp;
                count++;//copy
                count++;//paste
            }
            else{
                l=l+temp;
                count++;//paste
            }
        }
        return count;
    }
}