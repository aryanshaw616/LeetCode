class Pair {
    int num, idx;
    Pair(int n, int i) {
        num = n;
        idx = i;
    }
}
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<n; i++) 
            list.add(new Pair(nums[i],i));
        Collections.sort(list,(a,b)-> a.num-b.num);
        int ans[] = new int[n];

        int l = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).idx);

        for(int r = 1; r<n; r++) {
            if(list.get(r).num-list.get(r-1).num > limit) 
                for(; l<r; l++) ans[pq.poll()] = list.get(l).num;
            pq.add(list.get(r).idx);
        }
        
        while(l < n) ans[pq.poll()] = list.get(l++).num;
        
        return ans;
    }
}