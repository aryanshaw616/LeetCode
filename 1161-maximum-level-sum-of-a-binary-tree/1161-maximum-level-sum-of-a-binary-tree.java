class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=1,max=Integer.MIN_VALUE,maxlevel=0;
        while(q.size()>0)
        {
            int size=q.size();
            int sum=0;
            while(size-->0)
            {
                TreeNode currelement=q.poll();
                sum+=currelement.val;
                if(currelement.left!=null) q.add(currelement.left);
                if(currelement.right!=null) q.add(currelement.right);
            }
            if(max<sum)
            {
                max=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}