class Solution {

    private int min = Integer.MAX_VALUE;
    public String smallestNumber(String pattern) {
        backtrack(pattern, 0, new boolean[9], new StringBuilder());
        return String.valueOf(min);
    }

    private void backtrack(String pattern, int index, boolean[] used, StringBuilder sb) {
        if (index == pattern.length()) {
            min = Math.min(min, Integer.valueOf(sb.toString()));
            return;
        }
        if (usedAll(used)) return;
        for (int i = 1; i <= 9; ++i) {
            if (used[i - 1]) continue;
            if (sb.length() == 0) {
                sb.append(i);
                used[i - 1] = true;
                backtrack(pattern, index, used, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[i - 1] = false;
            } else {
                char ch = pattern.charAt(index);
                int lastDigit = sb.charAt(sb.length() - 1) - '0';
                if (ch == 'I') {
                    if (i <= lastDigit) continue;
                } else {
                    if (i >= lastDigit) continue;
                }
                sb.append(i);
                used[i - 1] = true;
                backtrack(pattern, index + 1, used, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[i - 1] = false;
            }
        }
    }

    private boolean usedAll(boolean[] used) {
        for (boolean b: used) {
            if (!b) return false;
        }
        return true;
    }
}