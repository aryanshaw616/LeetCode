class Solution {
    public int findNumbers(int[] nums) { int c=0;
        for(int i:nums)
        {
            String k=Integer.toString(i);
            if(k.length()%2==0)
            c++;
        }
        return c;
    }
}