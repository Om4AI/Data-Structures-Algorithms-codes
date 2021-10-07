// Code by @Om
import java.util.*;
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
//         Single node case
        if (head.next==null || left==right) return head;
        
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode hp = head;
        int c = 1;
        
        while(hp!=null){
            if (c!=left){
                p.next = hp;
                hp = hp.next;
                p = p.next;
                c++;
            }else if (c==left){
//                 Actual process for reversing
                ListNode rev = new ListNode(0);
                ListNode rp = rev;
//              Get nodes in the list (rev)
                while(hp!=null && c<=right){
                    rp.next = hp;
                    hp = hp.next;
                    rp = rp.next;
                    c++;
                }
                rp.next = null;
//                 Have all the nodes
//                 Reverse the LL
                p.next = reverse(rev);
                
//                 Get p tp the end of res
                while(p.next!=null) p=p.next;
            }
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
