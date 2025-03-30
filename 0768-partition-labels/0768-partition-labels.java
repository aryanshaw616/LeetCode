class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<n; i++) freq[s.charAt(i)-'a'] = i;
        
        int i=0;
        while(i<n){
            int end = freq[s.charAt(i)-'a'];
            for(int j=i; j<end; j++){
                end = Math.max(end, freq[s.charAt(j)-'a']);
            }
            res.add(end-i+1);
            i = end+1;
        }

        return res;
    }
}