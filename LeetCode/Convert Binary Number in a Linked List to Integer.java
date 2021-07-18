/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } */
 

// Each ListNode has a [val & next] except for the last node(doesn't have next)
// These are accessed using head.val & head.next

class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuffer sb = new StringBuffer();
        sb.append(head.val);
        while (head.next != null){
            head = head.next;
            sb.append(head.val);
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
