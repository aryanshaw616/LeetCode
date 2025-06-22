class Solution {
    public String[] divideString(String s, int k, char fill) {
    int remainder=0;
    int result=0;

        char[] chars=s.toCharArray();

    
        StringBuilder str=new StringBuilder();
    
        ArrayList<String> arr=new ArrayList<>();

        for(int i=0;i<chars.length;i++){
            str.append(chars[i]);
            if(str.length()==k){
                arr.add(str.toString());

                str.setLength(0);

            }
        }
         if (!str.isEmpty()) {
            remainder=str.length()%k;
            result=k-remainder;
            for(int i=1;i<=result;i++){
                 str.append(fill);
            }
             arr.add(str.toString());

}
           return arr.toArray(new String[0]);

    }
}