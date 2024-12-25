class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curr = queue.size();
            int curMax = Integer.MIN_VALUE;
            for(int i=0; i< curr; i++) {
                TreeNode node = queue.poll();
                curMax = Math.max(curMax, node.val);
                if(node.left != null) 
                    queue.add(node.left);
                if(node.right != null) 
                    queue.add(node.right);
            }
            ans.add(curMax);
        }
        return ans;
    }
}