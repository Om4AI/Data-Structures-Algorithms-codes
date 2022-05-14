import java.util.*;
public class Solution {
    public int kthsmallest(TreeNode root, int k) {
        List<Integer> nodes = getNodes(root);
        return getKthSmallest(nodes,k);
    }

    public static List<Integer> getNodes(TreeNode root){
        List<Integer> l = new ArrayList<Integer>();

        // Base condition
        if(root==null) return l;

        l.addAll(getNodes(root.left));
        l.addAll(getNodes(root.right));
        l.add(root.val);
        return l;
    }

    // Max Heap Approach (TC - nlogk)
    public static int getKthSmallest(List<Integer> l, int k){
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i: l){
            maxheap.add(i);
            if(maxheap.size()>k) maxheap.poll();
        }
        return maxheap.peek();
    }
}