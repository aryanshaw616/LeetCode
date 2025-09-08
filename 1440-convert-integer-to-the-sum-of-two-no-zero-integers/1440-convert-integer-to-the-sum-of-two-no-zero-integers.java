class Solution {
    public boolean isZero(int n){
        while(n!=0){
            int d=n%10;
            if(d==0) return false;
            n/=10;
        }

        return true;
    }
    public int[] getNoZeroIntegers(int n) {
       for(int i=1;i<n;i++){
           if(isZero(i) && isZero(n-i)){
              return new int[]{i,n-i};
           }
       }
      return new int[]{};
    }
}