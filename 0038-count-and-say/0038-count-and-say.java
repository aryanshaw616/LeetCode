class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 0; i < n - 1; i++) {
            char ss = res.charAt(0);
            StringBuilder s = new StringBuilder();
            int c = 1;
            for (int j = 1; j < res.length(); j++) {
                if (ss != res.charAt(j)) {
                    s.append(c);
                    s.append(ss);
                    c = 0;
                    ss = res.charAt(j);
                }

                c++;
            }
            s.append(c);
            s.append(ss);
            res = s.toString();

        }
        return res;
    }
}