/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class Solution {
    public ListNode solve(ListNode head, int k) {
        List<Integer> nodes = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        int f = 1;  // Variable to decide if current group must be reversed
        
        ListNode p = head;
        while(p!=null){
            temp.add(p.val);
            if(temp.size()==k){
                // Check for reversal of elements
                if(f==1){
                    Collections.reverse(temp);
                    f=0;
                }else f=1;
                nodes.addAll(temp);
                temp = new LinkedList<>();
            }
            p = p.next;
        }
        if(f==1){
            Collections.reverse(temp);
        }
        nodes.addAll(temp);
        
        // Construct LinkedList
        ListNode res = new ListNode(0);
        p = res;
        for(int i: nodes){
            ListNode t = new ListNode(i);
            p.next = t;
            p = p.next;
        }
        return res.next;
    }
}