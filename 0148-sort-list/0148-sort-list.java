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
    public ListNode sortList(ListNode A) {
        ListNode temp = A;
        List<Integer>list=new ArrayList<>();
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list);
         temp = A;
        for(int va:list)
        {
            temp.val=va;
            temp=temp.next;
        }
        return A;
    }
}
