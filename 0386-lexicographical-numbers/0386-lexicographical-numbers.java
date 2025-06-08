class Solution {

    static List<Integer> arr;
    static int k;

    static void helper(int n){
        if(n>k) return;
        if(n<=k && n!=0) arr.add(n);
        if(n==0){
            for(int i=1; i<=9; i++){
                helper(10*n+i);
            }
        }else{
            for(int i=0; i<=9; i++){
            helper(10*n+i);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        k=n;
        arr = new ArrayList<>();

        helper(0);
        return arr;
    }
}