class Solution {
    public int countPalindromicSubsequence(String s) {
        var m = new HashMap<Character, List<Integer>>();

        // 1. Create a map for each character
        for(int i = 0; i < s.length(); i++) {
            if(!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), new ArrayList<>());
            }
            m.get(s.charAt(i)).add(i);
        }
        int res = 0;

        // 2. Iterate through each valid palindromes of length three
        for(int i = 0; i < 26; i++) {
            // For 'xyx' to be valid there should be at least 2 'x's
            if(!m.containsKey((char) ('a'+i)) || m.get((char) ('a'+i)).size() < 2) {
                continue;
            }
            for(int j = 0; j < 26; j++) {
                // For 'xxx' to be valid there should be at least 3 'x's
                if(j == i) {
                    if(m.get((char) ('a'+i)).size() > 2) {
                        res++;
                    }
                    continue;
                }
                if(!m.containsKey((char) ('a'+j))) {
                    continue;
                }
                var l = m.get((char) ('a'+i)).getFirst();
                var r = m.get((char) ('a'+i)).getLast();
                var mi = m.get((char) ('a'+j));
                var li = Collections.binarySearch(mi, l);
                if(li < 0) {
                    li = -li-1;
                }
                var ri = Collections.binarySearch(mi, r);
                if(ri < 0) {
                    ri = -ri-1;
                }
                if(li != ri) {
                    res++;
                }
            }
        }
        return res;
    }
}