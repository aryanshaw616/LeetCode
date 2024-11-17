class Solution {
    public void moveZeroes(int[] a) {
        int i=0,j=0;
        while(j<a.length)
        {
            if(a[i]!=0)
            {
                i++;
                j++;
            }
            else if(a[j]==0)
            {
                j++;
            }
            else
           {
             a[i]=a[j];
            a[j]=0;
           }
        }
    }
}