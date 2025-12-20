class Solution {
    public int minDeletionSize(String[] strs) {
      int n = strs.length;
      int k = strs[0].length();
      int ans = 0;
      for(int i=0;i<k;i++){
            boolean flag = false;
            for(int j=1;j<n;j++){
                if(strs[j].charAt(i)-'a' < strs[j-1].charAt(i)-'a'){
                    flag=true;
                    break;
                }
            }
            if(flag) ans++;
        }
    return ans;
    }
}