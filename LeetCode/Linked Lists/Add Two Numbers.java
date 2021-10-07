// Code by @Om
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode();
        ListNode p = res;
        int c = 0;
        while(l1!=null || l2!=null){
            int l1_val = (l1!=null)? l1.val: 0;
            int l2_val = (l2!=null)? l2.val: 0;
            int sum = l1_val+l2_val+c;
            c = sum/10;
            int ld = sum%10;
            
            ListNode node = new ListNode(ld);
            p.next = node;
            
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
            p=p.next;
        }
        if (c==1){
            p.next = new ListNode(1);
        }
        return res.next;
    }
}
