class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); int max=Integer.MIN_VALUE;int k;
        for(int i=0;i<nums.length;i++)
        {  if (i<nums.length-3)
        {
            k=nums[i] + nums[i+1]+nums[i+2];
            if(k<target)
            max=Math.max(max,k);
        }
        }
        return max;
    }
}