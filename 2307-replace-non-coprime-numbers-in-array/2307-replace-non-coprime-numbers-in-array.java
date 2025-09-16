class Solution {
    static Map<String,Integer> dp=new HashMap<>();
    static int gcd(int a,int b){
        String key=a+","+b;
        if(dp.containsKey(key)) return dp.get(key);
        int result=(b==0)?a:gcd(b,a%b);
        dp.put(key,result);
        return result;
    }
    static int lcm(int a,int b){
        return (a/gcd(a,b))*b;
    }
    public List<Integer> replaceNonCoprimes(int[] nums){
        Stack<Integer> st=new Stack<>();
        for(int num:nums){
            int cur=num;
            while(!st.isEmpty()&&gcd(st.peek(),cur)>1){
                cur=lcm(st.pop(),cur);
            }
            st.push(cur);
        }
        return new ArrayList<>(st);
    }
}