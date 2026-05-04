class Solution {
   
    public void rotate(int[][] a) {
        int c,l;
        l=a.length;
        c=a[0].length;
        for(int i=0;i<l;i++)
        for(int j=i;j<c;j++)
        {
            int t=a[i][j];
            a[i][j]=a[j][i];
            a[j][i]=t;
        }
        
       for(int i=0;i<l;i++)
       {
        int li=0,ui=l-1;
        while(li<ui)
        {
             int k=a[i][ui];
            a[i][ui]=a[i][li];
            a[i][li]=k;

            li++;
            ui--;
        }
       }
    }
}