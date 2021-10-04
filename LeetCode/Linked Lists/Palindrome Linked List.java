// Code by @Om
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;

        // Divide the list into half
        ListNode l1 = head;
        ListNode prev=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode rev = reverse(slow);
        int f = 1;
        while(rev!=null && l1!=null && f==1){
            if (rev.val!=l1.val){
                f = 0;
                continue;
            }else{
                rev=rev.next;
                l1=l1.next;
            }
        }
        return f==1;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
