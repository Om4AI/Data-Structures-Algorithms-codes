// Slow & fast pointers approach
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head, fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// 2 Seperate pointers approach
class Solution {
    public ListNode middleNode(ListNode head) {
//         Find length of list
        ListNode p1 = head;
        int c = 0;
        while(p1!=null){
            c+=1;
            p1 = p1.next;
        }
//         Middle element finding
        int mid = c/2;
        ListNode res = head;
        while(res!=null && mid>0){
            res = res.next;
            mid--;
        }
        return res;
    }
}
