/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode f = head;
        ListNode s = head;
        ListNode p = null;
        int k=0;
        while(f!=null && f.next!=null)
        {
            f=f.next.next;
            p=s;
            s=s.next;
        }
        p.next=s.next;
       
        return head;
    }
}