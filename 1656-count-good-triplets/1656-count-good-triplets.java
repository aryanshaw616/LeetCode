class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int l = arr.length,c1=0;
        for(int i=0;i<l-2;i++)
        for(int j=i+1;j<l-1;j++)
        for(int k=j+1;k<l;k++)
        {
            if((Math.abs(arr[i] - arr[j]) <= a)&& (Math.abs(arr[j] - arr[k]) <= b) && Math.abs(arr[i] - arr[k]) <= c)
            c1++;
        }
        return c1;
    }
}