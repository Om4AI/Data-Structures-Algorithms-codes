class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        while (head!=null && head.val==val){
            head = head.next;
        }
        while(p!=null && p.next!=null){
            if (p.next.val == val){
                p.next = p.next.next;
            }
            else{p = p.next;}
        }
        return head;
    }
}
