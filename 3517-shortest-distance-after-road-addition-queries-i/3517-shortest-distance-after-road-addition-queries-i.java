class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int arr[] = new int[queries.length];
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            al.get(i).add(i + 1);
        }
        int index = 0;
        for (int query[] : queries) {
            int dist = 0;
            al.get(query[0]).add(query[1]);
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[n];
            visited[0] = true;
            q.add(0);
            a: while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int curr = q.poll();
                    if (curr == n - 1) {
                        arr[index++] = dist;
                        break a;
                    }
                    visited[curr] = true;
                    for (int k : al.get(curr)) {
                        if (!visited[k]) {
                            q.add(k);
                            visited[k] = true;
                        }
                    }
                }
                dist++;
            }
        }
        return arr;
    }
}