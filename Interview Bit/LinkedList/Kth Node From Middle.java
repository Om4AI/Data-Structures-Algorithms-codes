/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */


//  ----------------------------- Coded in a hurry -------------------------------
public class Solution {
    public int solve(ListNode A, int B) {
        // Find index
        int n =0 ;
        ListNode p = A;
        while(p!=null){
            n++;
            p = p.next;
        }
        
        int mid = n/2;
        int f = mid-B;
        
        if(f>=0){
            p = A;
            n = 0;
            while(p!=null){
                if(n==f) return p.val;
                n++;
                p = p.next;
            }
        }
        return -1;
    }
}
//  ----------------------------- Coded in a hurry -------------------------------