class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;

        ListNode l1 = head;   //Head of 1st half
        ListNode slow = head; //Head of 2nd half
        ListNode fast = head; //Tail of 2nd half
        ListNode prev = null; //Tail of 1st half

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next=null; // Separate the lists

        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2){
        while(l1!=null){
            ListNode l1_nt = l1.next;
            ListNode l2_nt = l2.next;

            l1.next = l2;
            if (l1_nt==null) break;

            l2.next = l1_nt;
            l1=l1_nt;
            l2=l2_nt;
        }
    }
}
