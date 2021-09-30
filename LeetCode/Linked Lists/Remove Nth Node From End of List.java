class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p=head;
        while(p!=null){
            len+=1;
            p=p.next;
        }
        int r=len-n;
//         Case 1 - Single element
        if (len==1) return null;
//         Case 2 - First element removal
        if (r==0 && len>1) return head.next;
        ListNode p1=head;
        int c =0;
        while(c<r && p1!=null){
//             Case 3 - Last element removal
            if (c==r-1 && r==len-1){
                p1.next = null;
            }else if (c==r-1){
                p1.next=p1.next.next;  //General case for removal
            }else{
                p1= p1.next;     //Next node traversal
            }
            c++;
        }
        return head;
    }
}
