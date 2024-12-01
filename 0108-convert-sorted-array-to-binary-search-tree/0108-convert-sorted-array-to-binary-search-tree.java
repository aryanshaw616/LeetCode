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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return helper(0,nums,nums.length-1);
    }
        static TreeNode helper(int i ,int a[],int j)
        {
            if(i>j)
            return null;
            int mid=(i+j)/2;
            TreeNode node=new TreeNode(a[mid]);
            node.left=helper(i,a,mid-1);
            node.right=helper(mid+1,a,j);
            return node;
        }
}