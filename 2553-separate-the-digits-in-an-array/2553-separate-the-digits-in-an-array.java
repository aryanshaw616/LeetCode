class Solution {
    public int[] separateDigits(int[] nums) {
       List<Integer>list=new ArrayList<>();
        String s="";
       for(int i:nums)
       s+=Integer.toString(i);
       for(char ch:s.toCharArray())
       list.add(ch-'0');
       int[] a = new int[list.size()];

for(int i=0;i<list.size();i++)
a[i]=list.get(i);

return a;
    }
}