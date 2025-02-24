class Solution {
    ArrayList<Integer>[] adj; // Adjacency list representation of the graph
    Map<Integer, Integer> bobPath; // Stores the path of Bob with time taken to reach each node
    int max = Integer.MIN_VALUE; // Stores the maximum profit Alice can collect
    int[] amount; // Stores the profit associated with each node
    boolean[] visited; // Tracks visited nodes to prevent cycles

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // Prepare adjacency list
        int n = amount.length;
        bobPath = new HashMap<Integer, Integer>();
        this.amount = amount;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        
        visited = new boolean[n];

        // Build the adjacency list from edges
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // Find Bob's path to node 0
        bobPath(bob, 0); // Starting node of Bob, time initialized to 0

        // Find Alice's maximum profit path
        Arrays.fill(visited, false); // Reset visited array
        alice(0, 0, 0); // Start Alice from node 0

        return max; // Return the maximum profit Alice can achieve
    }

    private boolean bobPath(int node, int time) {
        visited[node] = true;
        bobPath.put(node, time); // Store the time Bob reaches this node

        if(node == 0) { // If Bob reaches node 0, return true
            return true;
        }

        // Traverse neighbors to find a path to node 0
        for(int nei : adj[node]) {
            if(!visited[nei] && bobPath(nei, time + 1)) {
                return true;
            }
        }

        // Undo the path if not leading to node 0
        bobPath.remove(node);
        return false;
    }
    
    // DFS to calculate maximum income for Alice
    private void alice(int node, int time, int income) {
        visited[node] = true;

        // If Alice reaches first, collect full amount
        if(!bobPath.containsKey(node) || time < bobPath.get(node)) {
            income += amount[node];
        }
        // If both reach at the same time, collect half the amount
        else if(time == bobPath.get(node)) {
            income += amount[node] / 2;
        }
        
        // If leaf node (not root), update max profit
        if(adj[node].size() == 1 && node != 0) {
            max = Math.max(max, income);
        }

        // Recur for all unvisited neighbors
        for(int nei : adj[node]) {
            if(!visited[nei]) {
                alice(nei, time + 1, income);
            }
        }
    }
}