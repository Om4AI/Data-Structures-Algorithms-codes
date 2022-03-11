/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode p = new ListNode();
        p = head.next;
        ListNode prev = new ListNode();
        prev = head;
        
        // Calculate length of the LinkedList
        int n =0;
        ListNode ptr = new ListNode();
        ptr = head;
        while(ptr.next!=null){
            n++;
            ptr = ptr.next;   
        }
        n++;
        
        // Use the remainder to calculate the number of times to execute the loop of transition
        k%=n;
        
        // Actual loop
        while(k-->0){
            // Find the last & second last node
            while(p.next!=null){
                p = p.next;
                prev = prev.next;
            }

            // Point the last node to the first node to create a new LinkedList
            prev.next = null;
            p.next = head;
            head = p;
            // Reset the prev & p pointers for the next loop cycle
            prev = head;
            p = head.next;
        }
        return prev;
    }
}