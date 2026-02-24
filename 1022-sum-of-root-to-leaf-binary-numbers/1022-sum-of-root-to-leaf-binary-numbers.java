/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root, 0);
        return sum;
    }
    void solve(TreeNode root, int currSum) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            currSum=(currSum<<1)|root.val;
            sum+=currSum;
            return;
        }
        currSum=(currSum<<1)|root.val;
        solve(root.left, currSum);solve(root.right, currSum);
    }
}