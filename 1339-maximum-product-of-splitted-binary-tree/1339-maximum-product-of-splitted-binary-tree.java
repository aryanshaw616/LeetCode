class Solution {
    public int maxProduct(TreeNode root) {
        int mod = 1000000007;
        long totalSum = findTotalSum(root);
        long ans[] = new long[1];
        ans[0] = Long.MIN_VALUE;
        dfs(root, ans, totalSum);
    return (int) (ans[0] % mod);
    }
    public long findTotalSum(TreeNode root){
        if(root==null) return 0;
    return root.val + findTotalSum(root.left) + findTotalSum(root.right);
    }
    public long dfs(TreeNode root, long[] ans, long totalSum){
        if(root==null) return 0;
        long leftSum = dfs(root.left, ans, totalSum);
        long rightSum = dfs(root.right, ans, totalSum);
        long subtreeSum = leftSum + rightSum + root.val;
        ans[0] = Math.max(ans[0], (subtreeSum * (totalSum-subtreeSum)));
        return subtreeSum;
    }
}