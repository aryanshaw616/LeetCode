import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] m) {
        Map<String, Integer> f = new HashMap<>();
        
        for (int[] r : m) {
            StringBuilder p = new StringBuilder();
            int b = r[0]; 
            for (int x : r) {
                p.append(x == b ? '0' : '1'); 
            }
            String k = p.toString();
            f.put(k, f.getOrDefault(k, 0) + 1);
        }
        
        int max = 0;
        for (int c : f.values()) {
            max = Math.max(max, c);
        }
        return max;
    }
}
