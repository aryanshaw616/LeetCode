class Solution {
    private void dfsCycle(int u, Map<Integer, List<Integer>> graph, Set<Integer> visited, Map<Integer, Integer> onStackWithIdx, int[] maxCycle) {
        visited.add(u);
        onStackWithIdx.put(u,onStackWithIdx.size()+1);
        for(int v : graph.get(u)) {
            if(!visited.contains(v)) {
                dfsCycle(v, graph, visited, onStackWithIdx, maxCycle);
            }
            else if(onStackWithIdx.containsKey(v)) {
                maxCycle[0] = Math.max(maxCycle[0], onStackWithIdx.size()-onStackWithIdx.get(v) + 1);
            }
        }

        onStackWithIdx.remove(u);
    }
    public int maximumInvitations(int[] favorite) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int []indegree = new int[favorite.length];

        for(int i =0; i < favorite.length; ++i) {
            graph.putIfAbsent(i, new ArrayList<>());
            graph.putIfAbsent(favorite[i], new ArrayList<>());
            graph.get(i).add(favorite[i]);
            indegree[favorite[i]]++;

        }

        int []maxCycle = new int[1];
        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new HashSet<>();

        Map<Integer, Integer> onStackWithIdx = new LinkedHashMap<>();
        for(int u : graph.keySet()) {
            if(!visited.contains(u)) {
                dfsCycle(u, graph, visited, onStackWithIdx, maxCycle);
            }
        }

        int result = maxCycle[0];

        Queue<Integer> filamentQueue = new LinkedList<>();
        for(int u : graph.keySet()) {
            if(indegree[u] == 0) {
                filamentQueue.add(u);
            }
        }

        int[] dp = new int[favorite.length];
        for(int i = 0; i < favorite.length; ++i) {
            dp[i] = 1;
        }
        while(!filamentQueue.isEmpty()) {
            int u = filamentQueue.poll();
            
            for(int v : graph.get(u)) {
                indegree[v]-- ;
                if(indegree[v] == 0) {
                    filamentQueue.add(v);
                }
                dp[v] = Math.max(dp[v], dp[u] + 1);
            }
        } 
        int sum = 0;
        for(int i = 0; i < favorite.length; ++i) {
            if(i == favorite[favorite[i]]) {
                sum += (dp[i] + dp[favorite[i]]);
            }
        }
        sum = sum/2;
        result = Math.max(sum, result);
        return result;
    }
}