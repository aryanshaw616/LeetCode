class Solution {
    public String toGoatLatin(String sentence) {
        sentence+=" ";
        String st="";
        String s[]=sentence.split(" ");
        for(int i=0;i<s.length;i++)
        s[i]=latin(s[i],i);
        for(String k : s)
        st+=k+" ";
        return st.substring(0,st.length()-1);
    }
    static String latin(String s,int k)
    {
        if("AEIOUaeiou".indexOf(s.charAt(0))>-1) 
        s+="ma";
        else{
            s=s.substring(1)+String.valueOf(s.charAt(0));
            s+="ma";}
        for(int i=0;i<=k;i++)
        s+="a";
        return s;
    }
}