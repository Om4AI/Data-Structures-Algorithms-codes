/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A){
        List<Integer> odd = new LinkedList<>();
        List<Integer> even = new LinkedList<>();

        ListNode p = A;
        int c = 1;
        while(p!=null){
            if(c%2==0) even.add(p.val);
            else odd.add(p.val);
            p = p.next;
            c++;
        }

        Collections.reverse(even);
        
        // Create resultant LinkedList
        ListNode res = new ListNode(0);
        p = res;
        c =1;
        while(even.size()!=0 && odd.size()!=0){
            if(c%2==0){
                p.next = new ListNode(even.get(0));
                even.remove(0);
            }else{
                p.next = new ListNode(odd.get(0));
                odd.remove(0);
            }
            p = p.next;
            c++;
        }

        while(even.size()>0){
            p.next = new ListNode(even.get(0));
            even.remove(0);
            p = p.next;
        }

        while(odd.size()>0){
            p.next = new ListNode(odd.get(0));
            odd.remove(0);
            p = p.next;
        }

        return res.next;
    }
}
