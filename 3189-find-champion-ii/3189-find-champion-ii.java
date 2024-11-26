class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            addEdge(edge[0], edge[1]);
        }
        
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: adjList){
            for(int num: list){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        
        for(int i=0; i<n; i++){
            if(!map.containsKey(i)){
                ans.add(i);
            }
        }
        if(ans.size() != 1){
            return -1;
        }
        return ans.get(0);
    }
    public void addEdge(int u, int v){
        adjList.get(u).add(v);
    }
}