class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> res = new ArrayList<>();
        int top, bottom, left, right, d = 0;
        top = 0;
        bottom = m.length - 1;
        left = 0;
        right = m[0].length - 1;
        
        while (top <= bottom && left <= right) {
            if (d == 0) {
                for (int i = left; i <= right; i++) {
                    res.add(m[top][i]);
                }
                top++;
            } else if (d == 1) {
                for (int i = top; i <= bottom; i++) {
                    res.add(m[i][right]);
                }
                right--;
            } else if (d == 2) {
                for (int i = right; i >= left; i--) {
                    res.add(m[bottom][i]);
                }
                bottom--;
            } else {
                for (int i = bottom; i >= top; i--) {
                    res.add(m[i][left]);
                }
                left++;
            }
            d = (d + 1) % 4;
        }
        return res;
    }
}
