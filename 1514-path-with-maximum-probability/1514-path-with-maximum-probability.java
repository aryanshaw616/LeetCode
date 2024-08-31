class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Double, List<List<Double>>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double src = edge[0];
            double dest = edge[1];
            List<List<Double>> adjList1 = adj.getOrDefault(dest, new ArrayList<>());
            List<List<Double>> adjList2 = adj.getOrDefault(src, new ArrayList<>());
            adjList1.add(Arrays.asList(src, succProb[i]));
            adjList2.add(Arrays.asList(dest, succProb[i]));
            adj.put(dest, adjList1);
            adj.put(src, adjList2);
        }
        PriorityQueue<List<Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.get(0), a.get(0)));
        maxHeap.add(Arrays.asList(1.00, (double)start_node));
        Set<Double> visited = new HashSet<>();
        while (!maxHeap.isEmpty()) {
            List<Double> poll = maxHeap.poll();
            double probability = poll.get(0);
            double curr = poll.get(1);
            visited.add(curr);
            if(curr == (double) end_node) {
                return probability;
            }
            if(adj.containsKey(curr)) {
                for(List<Double> entry: adj.get(curr)) {
                    double neighbor = entry.get(0);
                    double edgeProbability = entry.get(1);
                    if(!visited.contains(neighbor)) {
                        double resProb = probability * edgeProbability;
                        maxHeap.add(Arrays.asList(resProb, neighbor));
                    }
                }
            }
        }
        return 0;
    }
}