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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode op = odd;
        
        ListNode even = new ListNode(0);
        ListNode ep = even;
        ListNode p = head;
        int index = 1;
        
        while(p!=null){
            // Even
            if(index%2==0){
                ep.next = new ListNode(p.val);
                ep = ep.next;
            }else{
                op.next = new ListNode(p.val);
                op = op.next;
            }
            p = p.next;
            index++;
        }
        
        op.next = even.next;
        return odd.next;
    }
}