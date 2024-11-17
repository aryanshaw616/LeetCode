// sliding window + monotic stack(here dequeue)

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair> dq = new ArrayDeque<>(); // index, sum
        long sum = 0;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum >= k) {
                shortest = Math.min(shortest, i + 1); // Sum from start to i-th index
            }

            // Reduce window size to find minimum window with sum >= k
            while (!dq.isEmpty() && sum - dq.peekFirst().sum >= k) {
                shortest = Math.min(shortest, i - dq.pollFirst().index);
            }

            // Maintain monotonically non-decreasing order of deque
            while (!dq.isEmpty() && sum <= dq.peekLast().sum) {
                dq.pollLast();
            }
            dq.addLast(new Pair(sum, i)); // Push i-th sum
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    static class Pair {
        long sum;
        int index;

        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}