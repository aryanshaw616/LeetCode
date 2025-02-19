public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode f =  headA;
        ListNode s =  headB;
        if(headA==headB) return headA;
        while(f!= null || s!= null)
        {
            if(f!=null)
            f=f.next;
            else
            f=headB;
             if(s!=null)
            s=s.next;
            else
            s=headA;
            if(f==s)
            return f;
        }
        return null;
    }
}