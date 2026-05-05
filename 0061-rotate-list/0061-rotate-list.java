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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=new ListNode();
        if (head == null || head.next == null || k == 0) {
            return head; 
        }
        ListNode Last=head;
        int size=1;
        
        while(Last.next!=null){
            Last=Last.next;
            size++;
        }
        k=k%size;
        if(k==0){
            return head;
        }
        ListNode newTail=head;
        for(int i=1;i<size-k;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        Last.next=head;
        return newHead;
        
    }
}