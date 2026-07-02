class Solution {
    public String[] findWords(String[] words) {
        List<String>list=new ArrayList<>();
        String r1="qwertyuiop";
        String r2="asdfghjkl";
        String r3="zxcvbnm";
        String s2="";
        for(String s: words)
        {
            s2=s.toLowerCase();
            if(contain(s2,r1)) list.add(s);
            if(contain(s2,r2)) list.add(s);
            if(contain(s2,r3)) list.add(s);
        }
        String s1[]=new String[list.size()];
        int c=0;
        for(String s:list)
        s1[c++]=s;
        return s1;
            }
            boolean contain(String s , String r)
            {
                for(char ch:s.toCharArray())
                {
                   if (r.indexOf(ch) == -1)
                    return false;
                }
                return true;
            }
}