import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            // Condition when there is no loop
            if (fast==null || fast.next==null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
