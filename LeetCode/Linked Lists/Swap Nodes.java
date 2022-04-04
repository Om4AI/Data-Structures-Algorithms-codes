import java.util.*;
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int i=1;
        ListNode p = head.next;
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        ListNode res = new ListNode();

        // Find the total length of the LinkedList
        int n = 1;
        ListNode t = head;
        while(t.next!=null){
            t = t.next;
            n++;
        }
        if(n==1) return head;

        // Case of first node
        if(k==1 || k==n){
            k = 1;
            // Find p2
            p1.val = head.val;
            while(p.next!=null) p = p.next;
            p2.val = p.val;
            i = 1;
            p = head.next;
            res.val = p2.val;
            int lower = (k-1)<(n-k)? (k-1):(n-k);
            int upper = (k-1)>(n-k)? (k-1):(n-k);
            return construct_List(i,n,p,p1,p2,lower,upper,res);
        }

        // Find the 2 nodes that need to be swapped
        int lower = (k-1)<(n-k)? (k-1):(n-k);
        int upper = (k-1)>(n-k)? (k-1):(n-k);
        while(i<n && p.next!=null){
            if(i==lower){
                p1.val = p.val;
            }
            if(i==upper){
                p2.val = p.val;
            }
            p = p.next;
            i++;
        }
        i = 1;
        p = head.next;
        res.val = head.val;
        return construct_List(i,n,p,p1,p2,lower,upper,res);
    }

    // Function to construct the new LinkedList using the swapped order
    public static ListNode construct_List(int i, int n, ListNode p, ListNode p1, ListNode p2, int lower, int upper, ListNode res){
        ListNode rp = res;
        while(i<n && p!=null){
            if(i==lower){
                ListNode temp = new ListNode(p2.val);
                rp.next = temp;
            }
            else if(i==upper){
                ListNode temp = new ListNode(p1.val);
                rp.next = temp;
            }
            else{
                ListNode temp = new ListNode(p.val);
                rp.next = temp;
            }
            p = p.next;
            rp = rp.next;
            i++;
        }
        return res;
    }
}