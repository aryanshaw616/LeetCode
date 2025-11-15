class Solution {
    public int[] shuffle(int[] a, int n) {
        int[] r1 = new int[2*n];
        int i = 0, j = n, k = 0;
        while (i < n) {
            r1[k++] = a[i++];
            r1[k++] = a[j++];
        }
        return r1;
    }
}