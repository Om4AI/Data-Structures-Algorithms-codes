// Merge 2 sorted LinkedList

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(); //New LinkedList
        ListNode p = res; //Pointer for the LinkedList
        
        while(l1!=null && l2!=null){
            if (l1.val<=l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
//         Remaining nodes in the lists
        p.next = l1==null? l2:l1;
        return res.next;
    }
}
