class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head==null || head.next==null) return head;
        
        ListNode hp = head;
        ListNode res = new ListNode(0);
        ListNode p = res;
        
        while(hp!=null){
//             Form a new LinkedList
            ListNode rev = new ListNode(0);
            ListNode rp = rev;
            int c = 1;
            while(hp!=null && c<=k){
                rp.next = hp;
                hp = hp.next;
                rp = rp.next;
                c++;
            }
            rp.next = null;
//             K elements present
            if (c==k+1){
                p.next = reverse(rev);
            }else p.next = rev.next;
            
            while(p.next!=null) p = p.next;
        }
        return res.next;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head.next;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
