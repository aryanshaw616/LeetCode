class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        int l=m+n;
        int res[]=new int[l];
        for(int i =0;i<l;i++)
        {
            if(i<m)
            res[i]=nums1[i];
            else
            res[i]=nums2[i-m];
        }
        Arrays.sort(res);
        if(l%2!=0) { 
        int k=l/2;
       return (double)res[k];
        }
        else
        {
            int j=l/2;
            return (res[j-1]+res[j])/2.0;
        }
    }
}