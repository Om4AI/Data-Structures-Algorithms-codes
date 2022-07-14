public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a){
        ListNode res = new ListNode(0);
        ListNode p = res;

        List<Integer> els = new ArrayList<>();
        // Get all the elements
        for(ListNode list: a){
            ListNode t = list;
            while(t!=null){
                els.add(t.val);
                t = t.next;
            }
        }
        Collections.sort(els);

        // Create new LinkedList
        for(int el: els){
            p.next = new ListNode(el);
            p = p.next;
        }
        return res.next;
	}
}