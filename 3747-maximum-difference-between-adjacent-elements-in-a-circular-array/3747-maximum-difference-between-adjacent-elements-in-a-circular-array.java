class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int l=nums.length;
        int d=Math.abs(nums[l-1]-nums[0]);
        for(int i=1;i<l;i++)
            {
                int r=Math.abs(nums[i]-nums[i-1]);
                d=Math.max(d,r);
            }
        return d;
    }
}