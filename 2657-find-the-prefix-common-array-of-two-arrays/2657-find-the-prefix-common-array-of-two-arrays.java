class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> dict = new HashMap<>();
        int[] ans = new int[A.length];
        int count = 0;
        for(int i = 0; i < A.length; i++){
            dict.put(A[i], dict.getOrDefault(A[i], 0) + 1);
            dict.put(B[i], dict.getOrDefault(B[i], 0) + 1);
            if(A[i] == B[i]){
                count++;
            }
            else {
                if(dict.get(A[i]) == 2){
                    count++;
                }
                if(dict.get(B[i]) == 2){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}