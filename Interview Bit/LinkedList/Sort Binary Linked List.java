/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode res = new ListNode(0);
        ListNode p1 = res;
        ListNode p = A;
        while(p!=null){
            if(p.val==0){
                p1.next = new ListNode(0);
                p1 = p1.next;
            }
            p = p.next;
        }
        
        p = A;
        while(p!=null){
            if(p.val==1){
                p1.next = new ListNode(1);
                p1 = p1.next;
            }
            p = p.next;
        }
        
        return res.next;
    }
}
