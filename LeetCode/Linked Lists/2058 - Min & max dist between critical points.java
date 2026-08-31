import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Solution 1 - First approach - 11ms 
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> pos = new ArrayList<>();
        ListNode prev = null;
        int p = 0;
        while (head.next!=null){
            if (prev!=null && head.next!=null){
                if (prev.val<head.val && head.val>head.next.val) pos.add(p);
                if (prev.val>head.val && head.val<head.next.val) pos.add(p);
            }
            p++;
            prev = head;
            head = head.next;
        }

        // No critical points
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (pos.size()==0 || pos.size()==1) return res;

        // General case
        res[0] = Integer.MAX_VALUE;
        res[1] = pos.get(pos.size()-1) - pos.get(0);
        for (int i=0; i<pos.size()-1; i++){
            res[0] = Math.min(res[0], pos.get(i+1)-pos.get(i));
        }
        return res;
    }
}

// Solution 2 - Optimized approach - 5ms (Lesser space & time)
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Init
        ListNode prev = null;
        int p = 0, first = -1, prevCpPos = -1, cpCount = 0;
        int res[] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        while (head.next!=null){
            if (prev!=null && head.next!=null){
                if ((prev.val<head.val && head.val>head.next.val) || (prev.val>head.val && head.val<head.next.val)) {
                    if (first==-1) first = p;
                    cpCount++;

                    // Max distance
                    res[1] = Math.max(res[1], p-first);

                    // Min distance
                    if (prevCpPos!=-1){ // If critical point exists before current point
                        res[0] = Math.min(res[0], p-prevCpPos);
                    }
                    prevCpPos = p;
                }
            }
            prev = head;
            head = head.next;
            p++;
        }

        if (cpCount<=1) return new int[]{-1,-1};
        return res;
    }
}