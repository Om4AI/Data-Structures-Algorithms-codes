class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode s = list1;
//         Initial a nodes
        for (int i=1; i<a; i++){s = s.next;}
        
//         One node through list1 
        ListNode l1 = s;
        for (int i=a; i<=b; i++){l1 = l1.next;}
        
//         Connect list2
        s.next = list2;
        while (list2.next != null){list2 = list2.next;}
        
//         Final connect to list1
        list2.next = l1.next;
        
        return list1;
    }
}
