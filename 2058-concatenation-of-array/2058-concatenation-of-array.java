class Solution {
    public int[] getConcatenation(int[] nums) {
         int n=nums.length;
        int x=nums.length*2;
        int n2[]=new int[x];
        for(int i=0;i<x;i++)
        n2[i]=nums[i%n];
        return n2;
    }
}