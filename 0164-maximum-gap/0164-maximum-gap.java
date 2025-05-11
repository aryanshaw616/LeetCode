class Solution {
    public int maximumGap(int[] nums) {
        int l = nums.length;
        if(l<=1) return 0;
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<l-1;i++)
            max=Math.max( (Math.abs(nums[i]-nums[i+1])),max);
            return max;
    }
}