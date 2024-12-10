class Solution {
    public int maximumLength(String s) {
        int maxLength = s.length()-2;
        HashMap<String, Integer>mMap = new HashMap();

        int ans = -1;

        while(maxLength > 0){
            for(int i=0;i<=s.length()-maxLength;i++){
                //System.out.println(s.substring(i, i+maxLength));
                String str = s.substring(i, i+maxLength);
                if(helper(str))mMap.put(str, mMap.getOrDefault(str, 0)+1);
            }
            //System.out.println();
            maxLength--;
        }

        for(Map.Entry<String, Integer>entry:mMap.entrySet()){
            if(entry.getValue() >= 3){
                ans = Math.max(entry.getKey().length(), ans);
            }
        }

        return ans;

    }

    public boolean helper(String s) {
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) != s.charAt(0)) {
            return false;
        }
    }
    return true;
}

}