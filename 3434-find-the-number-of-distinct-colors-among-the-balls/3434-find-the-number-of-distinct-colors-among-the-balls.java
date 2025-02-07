class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> colorMap = new HashMap<>();
        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
          int ball = queries[i][0];
          int color = queries[i][1];
          if(hm.containsKey(ball)){
            int prevColor = hm.get(ball);
            int count = colorMap.get(prevColor);
            if(count == 1){
              colorMap.remove(prevColor);
            }
            else{
              colorMap.put(prevColor, colorMap.get(prevColor)-1);
            }
          }
          hm.put(ball, color);
          colorMap.put(color, colorMap.getOrDefault(color, 0)+1);
          ans[i] = colorMap.size();
        }
        return ans;
    }
}