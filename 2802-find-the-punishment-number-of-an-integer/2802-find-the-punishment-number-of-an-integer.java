class Solution {
    public int punishmentNumber(int n) {
        int punishmentNo = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canBePartitioned(String.valueOf(square), 0, i)) {
                punishmentNo += square;
            }
        }

        return punishmentNo;
    }

    private boolean canBePartitioned(String squareStr, int index, int target) {
        if (index == squareStr.length()) {
            return target == 0;
        }

        int num = 0;
        for (int i = index; i < squareStr.length(); i++) {
            num = num * 10 + (squareStr.charAt(i) - '0');

            if (num > target) {
                break;
            }

            if (canBePartitioned(squareStr, i + 1, target - num)) {
                return true;
            }
        }

        return false;
    }
}