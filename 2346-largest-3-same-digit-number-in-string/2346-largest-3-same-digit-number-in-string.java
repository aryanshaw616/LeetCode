class Solution {
    public String largestGoodInteger(String s) {
        List<String>list=new ArrayList<>();
        for(int i=0;i<s.length()-2;i++)
        {
            String k=s.substring(i,i+3);
            if((k.charAt(0)==k.charAt(1))&& (k.charAt(0)==k.charAt(2)))
            list.add(k);
        }
        if(list.isEmpty()) return "";
        return Collections.max(list);
    }
}