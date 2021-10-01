// Code by @Om
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;

//         Initialize pointers 
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
      
//       Get the boundaries 
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
//       Terminate the temp pointer 
        temp.next = null;

        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);

        return merge(left_side, right_side);
    }

  
//   Merge function
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode curr = res;

//       Sorting
        while(l1!=null && l2!=null){
            if (l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2=l2.next;
            }
            curr = curr.next;
        }
//       Add the remaining elements 
        if (l1!=null){
            curr.next= l1;
            l1 = l1.next;
        }
        if (l2!=null){
            curr.next= l2;
            l2 = l2.next;
        }
//       Return the merged sorted result
        return res.next;
    }
}
