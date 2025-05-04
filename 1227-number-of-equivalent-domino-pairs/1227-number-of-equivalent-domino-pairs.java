class Solution {
    private static final int[][] DOMINO_INDICES = {
        // 0
        {},
        // 1
        { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8 },
        // 2
        { -1, 1, 9, 10, 11, 12, 13, 14, 15, 16 },
        // 3
        { -1, 2, 10, 17, 18, 19, 20, 21, 22, 23, },
        // 4
        { -1, 3, 11, 18, 24, 25, 26, 27, 28, 29 },
        // 5
        { -1, 4, 12, 19, 25, 30, 31, 32, 33, 34 },
        // 6
        { -1, 5, 13, 20, 26, 31, 35, 36, 37, 38 },
        // 7
        { -1, 6, 14, 21, 27, 32, 36, 39, 40, 41 },
        // 8
        { -1, 7, 15, 22, 28, 33, 37, 40, 42, 43 },
        // 9
        { -1, 8, 16, 23, 29, 34, 38, 41, 43, 44 }
    };

    public int numEquivDominoPairs(final int[][] dominoes) {
      final int[] counts = new int[45]; // equals to max(dominoIndices) + 1
      for (final int[] domino : dominoes) ++counts[DOMINO_INDICES[domino[0]][domino[1]]];
      int result = 0;
      for (final int count : counts) {
        if (count <= 1) continue;
        result += (count - 1) * count / 2;
      }
      return result;
    }
}