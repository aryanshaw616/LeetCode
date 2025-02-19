class Solution {
    List<String>ans=new ArrayList<>();
    public void f(int n,String s,char prev){
        if(s.length()==n){
            ans.add(s);
            return;
        }

        for(char ch='a';ch<='c';ch++){
            if(ch!=prev){
                f(n,s+ch,ch);
            }else{
                continue;
            }
        }
    }
    public String getHappyString(int n, int k) {
        f(n,"",'d');
        System.out.println(ans);
        if(ans.size()>=k){
            return ans.get(k-1);
        }else{
            return "";
        }
    }
}