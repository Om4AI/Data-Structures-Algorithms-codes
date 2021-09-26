class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        ListNode p = res;
        
        if (head==null) return res.next;
        
        while(head.next!=null){
            if (head.val != val){
                p.next = head;
                p = p.next;
                head = head.next;
            }
            else if(head.val == val) head = head.next;
        }
        if (head.val==val) p.next = null;
        else p.next = head;
        return res.next;
    }
}
