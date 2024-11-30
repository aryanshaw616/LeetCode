class Solution {
    List<Integer> c;
    public int[][] validArrangement(int[][] p) {
        Map<Integer, List<Integer>> g = new HashMap();
        Map<Integer, Integer> n = new HashMap();

        for (int[] e : p) {
            g.computeIfAbsent(e[0], k -> new ArrayList()).add(e[1]);
            n.put(e[0], n.getOrDefault(e[0], 0) - 1);
            n.put(e[1], n.getOrDefault(e[1], 0) + 1);
        }

        int s = p[0][0];
        for (Map.Entry<Integer, Integer> e : n.entrySet()) {
            if (e.getValue() == -1) {
                s = e.getKey();
                break;
            }
        }

        c = new ArrayList();
        dfs(g, s);
        Collections.reverse(c);

        int[][] r = new int[p.length][2];
        for (int i = 1; i < c.size(); i++) {
            r[i - 1][0] = c.get(i - 1);
            r[i - 1][1] = c.get(i);
        }

        return r;
    }

    void dfs(Map<Integer, List<Integer>> g, int u) {
        while (g.containsKey(u) && !g.get(u).isEmpty()) {
            dfs(g, g.get(u).remove(0));
        }
        c.add(u);
    }
}
