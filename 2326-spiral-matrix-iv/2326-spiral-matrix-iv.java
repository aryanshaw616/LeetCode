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
    public int[][] spiralMatrix(int m, int n, ListNode head) {

       int[][] ans=new int[m][n];

       for(int i=0;i<m;i++) Arrays.fill(ans[i],-1);

       int srt_row=0,end_row=m-1,srt_col=0,end_col=n-1;

       ListNode cur=head;

       while(cur!=null){

            for(int i=srt_col;i<=end_col && cur!=null;i++){
                ans[srt_row][i]=cur.val;
                cur=cur.next;
            }
            srt_row++;

            for(int i=srt_row;i<=end_row && cur!=null;i++){
                ans[i][end_col]=cur.val;
                cur=cur.next;
            }
            end_col--;

            for(int i=end_col;i>=srt_col && cur!=null;i--){
                ans[end_row][i]=cur.val;
                cur=cur.next;
            }
            end_row--;

            for(int i=end_row;i>=srt_row && cur!=null;i--){
                ans[i][srt_col]=cur.val;
                cur=cur.next;
            }
            srt_col++;

       }
       return ans;
    }
}