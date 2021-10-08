class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode();
        ListNode curr = head;
        
        while(curr!=null){
            ListNode prev = res;
            
            while(prev.next!=null && prev.next.val<curr.val){
                prev = prev.next;
            }
            
//             Store the next node to later get node back
            ListNode next = curr.next;
            
//             Insert node into LinkedList
            curr.next = prev.next;
            prev.next = curr;
            
//             Continue with the old node 
            curr = next;
        }
        return res.next;
    }
}
