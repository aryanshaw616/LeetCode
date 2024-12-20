class Solution {
   public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int lvl=0; !q.isEmpty(); lvl++){
            int size = q.size();
            TreeNode[] arr = new TreeNode[size];
            for(int i=0; i<size; i++) {
                arr[i] = q.poll();
                if(arr[i].left!=null) q.add(arr[i].left);
                if(arr[i].right!=null) q.add(arr[i].right);
            }
            if(lvl%2!=0) reverse(arr);
        }
        return root;
    }

    void reverse(TreeNode[] arr){
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            int temp = arr[i].val;
            arr[i].val = arr[j].val;
            arr[j].val = temp;
        }
    }
}