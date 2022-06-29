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

 
// ---------------------------- Linear extra space code O(n) -----------------------------
class Solution {
    public ListNode partition(ListNode head, int x){
        
        // Base case
        if(head==null) return null;
        
        List<Integer> l = new LinkedList<>();
        List<Integer> g = new LinkedList<>();
        ListNode p1 = head;
        
        while(p1!=null){
            if(p1.val<x) l.add(p1.val);
            else g.add(p1.val);
            p1 = p1.next;
        }
        
        ListNode res = new ListNode();
        ListNode p = res;
        for(int i: l){
            ListNode temp = new ListNode(i);
            p.next = temp;
            p = p.next;
        }
        for(int i: g){
            ListNode temp = new ListNode(i);
            p.next = temp;
            p = p.next;
        }
        
        return res.next;
    }
}


// ---------------------------- Constant extra space code O(n) -----------------------------
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