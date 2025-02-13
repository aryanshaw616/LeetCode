class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> p = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            p.add((long)nums[i]);
        }
        int flag = 0;
        while(p.peek() < k && p.size() >= 2){
            ++flag;
            long x = p.poll();
            long y = p.poll();
            p.add(Math.min(x,y)*2+Math.max(x,y));
        }
        return flag;
    }
}