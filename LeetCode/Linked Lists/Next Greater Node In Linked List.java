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
import java.util.*;
class Solution {
    public int[] nextLargerNodes(ListNode head){

        // Find the length of the LinkedList
        ListNode p = head;
        int n = 0;
        while(p!=null){
            n++;
            p = p.next;
        }

        int res[] = new int[n];
        p = head;
        int i=0;
        while(p!=null){
            ListNode inp = p.next;
            int f =0;
            while(inp!=null){
                if(p.val<inp.val){
                    f = 1;
                    res[i] = inp.val;
                    break;
                }
                inp = inp.next;
            }
            res[i] = (f==0)?0:res[i];

            p = p.next;
            i++;
        }
        return res;
    }
}