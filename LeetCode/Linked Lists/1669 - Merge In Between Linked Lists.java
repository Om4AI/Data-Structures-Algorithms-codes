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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int ptr_ind = 0;

        // Get the pointer to b to join later
        ListNode bptr = list1;
        while(ptr_ind<=b){
            bptr = bptr.next;
            ptr_ind++;
        }

        // Get to a and append list2
        ListNode aptr = list1;
        ptr_ind = 0;
        while(ptr_ind<(a-1)){
            aptr = aptr.next;
            ptr_ind++;
        }
        aptr.next = list2;
        
        // Attach the other half to the resultant list
        aptr = list1;
        while(aptr.next!=null){ aptr = aptr.next;}
        aptr.next = bptr;
        return list1;
    }
}