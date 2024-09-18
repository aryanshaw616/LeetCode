class Solution {
    public String largestNumber(int[] nums) {   
        if(nums.length==0)
            return "";
        String[] conv=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            conv[i]=Integer.toString(nums[i]);
        Arrays.sort(conv,(a,b) -> (b+a).compareTo(a+b));
        StringBuilder res=new StringBuilder();
        if(conv[0].equals("0"))
            return "0";
        for(int i=0;i<conv.length;i++)
        {
            res.append(conv[i]);
        }
        return res.toString();
    }
}