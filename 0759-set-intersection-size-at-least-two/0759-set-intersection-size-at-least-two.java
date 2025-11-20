class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );
        int res = 0;
        int p1 = -1, p2 = -1; 
        for (int[] iv : intervals) {
            int start = iv[0], end = iv[1];
            if (p2 < start) {
                res += 2;
                p1 = end - 1;
                p2 = end;
            }
            else if (p1 < start) {
                res += 1;
                p1 = p2;
                p2 = end;
            }
        }
        return res;
    }
}