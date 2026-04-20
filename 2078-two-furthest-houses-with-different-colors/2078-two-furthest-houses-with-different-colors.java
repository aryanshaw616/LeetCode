class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi = 0;

        for(int j=n-1; j>=0; j--) {
            if(colors[j] != colors[0]) {
                maxi = Math.max(maxi, j);
                break;
            }
        }

        for(int i=0; i<n; i++) {
            if(colors[i] != colors[n-1]) {
                maxi = Math.max(maxi, n-i-1);
                break;
            }
        }

        return maxi;
    }
}