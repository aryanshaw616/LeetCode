class Solution {
    List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]) dfs(i, vis, pathVis, graph);
        }

        for(int i = 0; i < V ; i++){
            if(vis[i] && !pathVis[i]) res.add(i);
        }
        return res;
    }


    private  boolean dfs(int node, boolean[] vis, boolean[] pathVis, int[][] adj){
        vis[node] = true;
        pathVis[node] = true;

        for(int i : adj[node]){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj)) return true;
            }
            else if(pathVis[i]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}