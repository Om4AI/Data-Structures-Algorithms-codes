/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode p = res, l = head;
        
        while(l!=null){
            if(l.val<x){
                ListNode temp = new ListNode(l.val);
                p.next = temp;
                p = p.next;
            }
            l = l.next;
        }
        
        l = head;
        while(l!=null){
            if(l.val>=x){
                ListNode temp = new ListNode(l.val);
                p.next = temp;
                p = p.next;
            }
            l = l.next;
        }
        return res.next;
    }
}
