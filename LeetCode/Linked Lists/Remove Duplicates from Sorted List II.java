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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // Fill up map
        ListNode p = head;
        while(p!=null){
            map.put(p.val, map.getOrDefault(p.val,0)+1);
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