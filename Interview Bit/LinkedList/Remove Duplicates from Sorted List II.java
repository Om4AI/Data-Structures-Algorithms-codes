/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // Fill up map
        ListNode p = head;
        while(p!=null){
            if(map.containsKey(p.val)){
                map.put(p.val, map.get(p.val)+1);
            }else map.put(p.val, 1);
            p = p.next;
        }
        
        // Create list & sort
        List<Integer> l = new LinkedList<>();
        for(int k: map.keySet()){
            if(map.get(k)==1) l.add(k);
        }
        Collections.sort(l);
        
        // Construct the resultant LinkedList
        ListNode res = new ListNode(0);
        p = res;
        for(int i: l){
            ListNode temp = new ListNode(i);
            p.next = temp;
            p = p.next;
        }
        return res.next;
    }
}
