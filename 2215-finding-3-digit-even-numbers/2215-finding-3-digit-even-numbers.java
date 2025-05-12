class Solution {

    public int[] findEvenNumbers(int[] digits) {
        final int[] frequencies = new int[10];
        for (int digit : digits) {
            frequencies[digit]++;
        }
        final int[] valid = new int[450];
        int v = 0;
        for (int i = 1; i < 10; i++) {
            if (frequencies[i] > 0) {
                frequencies[i]--;
                for (int j = 0; j < 10; j++) {
                    if (frequencies[j] > 0) {
                        frequencies[j]--;
                        for (int k = 0; k < 10; k += 2) {
                            if (frequencies[k] > 0) {
                                valid[v++] = (100 * i) + (10 * j) + k;
                            }
                        }
                        frequencies[j]++;
                    }
                }
                frequencies[i]++;
            }
        }
        return Arrays.copyOf(valid, v);
    }

}