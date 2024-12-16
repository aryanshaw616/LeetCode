class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        int numsSize = nums.length;
        int num = 0;
        int i = 0;
        int index = 0;
        int[] ele;
        for (i = 0; i < numsSize; i++) {
            minHeap.add(new int[] { nums[i], i });
        }
        while (k > 0) {
            ele = minHeap.poll();
            num = ele[0] * multiplier;
            index = ele[1];
            minHeap.add(new int[] { num, index });
            k--;
        }
        i = 0;
        while (i < numsSize) {
            ele = minHeap.poll();
            nums[ele[1]] = ele[0];
            i++;
        }
        return nums;
    }

}