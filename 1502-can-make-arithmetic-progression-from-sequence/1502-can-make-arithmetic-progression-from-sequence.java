class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff=(int)Math.abs(arr[1]-arr[0]);
        for(int i=1;i<arr.length-1;i++)
        if((int)Math.abs(arr[i]-arr[i+1]) !=diff)
         return false;
         return true;    }
}