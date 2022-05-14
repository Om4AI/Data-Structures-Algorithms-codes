// Less Optimized Solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
        List<Integer> l = new ArrayList();
        l.add(root.val);
        l.addAll(get_nodes(root.left));
        Collections.sort(l);
        return l.get(k-1);
    }
    
    public List<Integer> get_nodes(TreeNode root){
        List<Integer> t = new ArrayList<>();
        if (root==null) return t;
        else{
            t.add(root.val);
        }
        t.addAll(get_nodes(root.left));
        t.addAll(get_nodes(root.right));
        return t;
    }
}





// Optimized approach (Heaps)
import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
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


