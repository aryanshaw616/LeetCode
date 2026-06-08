class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer>one=new ArrayList<>();
        ArrayList<Integer>two=new ArrayList<>();
        int c=0;
        for(int i : nums)
        {
            if(i<pivot)
            one.add(i);
            else if (i>pivot)
            two.add(i);
            else
            c++;
        }
        for(int i=0;i<c;i++)
        one.add(pivot);
        one.addAll(two);
         int[] arr = new int[one.size()];
        for (int i = 0; i < one.size(); i++) 
            arr[i] = one.get(i);
            return arr;
    }
}