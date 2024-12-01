class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    static TreeNode helper(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode mid = findMiddle(start, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = helper(start, mid);
        node.right = helper(mid.next, end);

        return node;
    }

    static ListNode findMiddle(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
