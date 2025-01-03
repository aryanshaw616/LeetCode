class Solution {
    public int waysToSplitArray(int[] nums) {
        long [] prefix = new long[nums.length + 1];
        int ans = 0;
        long sum1 = Arrays.stream(nums).mapToLong(i -> i).sum();
        for(int i = 1; i <= nums.length -1; i++)
        {
            prefix[i] = nums[i-1] + prefix[i-1];
            if(prefix[i] >= (sum1 - prefix[i]))
            {
                ans+=1;
            }
            // System.out.println(Arrays.toString(prefix)+" "+ans);
        }
        return ans;
    }
}