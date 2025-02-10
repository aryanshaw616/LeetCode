class Solution {
    public String clearDigits(String s) {
        int index = 0;

        StringBuilder sb = new StringBuilder(s);

        while (index < sb.length()) {

            if (Character.isDigit(sb.charAt(index))) {
                sb.deleteCharAt(index);

                if (index > 0) {
                    sb.deleteCharAt(index - 1);
                    index--;
                }
            } else index++;
        }
        return sb.toString();
    }
}