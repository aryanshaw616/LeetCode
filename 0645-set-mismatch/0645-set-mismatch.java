class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer>set=new HashSet<>();
        int k=0,a[]=new int[2];
        for(int i:nums){
        if(set.contains(i))
        k=i;
        else
        set.add(i);
        }
        int n = nums.length;
        int f=(n*(n+1))/2;
        int s=Arrays.stream(nums).sum();
        s=s-k;
        a[0]=k;
        a[1]=f-s;
        return a;
    }
}