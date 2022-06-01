import java.util.*;
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;

        levelOrderTree(root);
    }

    public static void levelOrderTree(TreeLinkNode root){
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            while(n-->0){
                TreeLinkNode node = q.poll();

                // Node's next pointer logic
                // (Set node's next pointer)
                if(q.peek()!=null && n!=0){
                    node.next = q.peek();
                }else node.next = null;

                // Children addition logic to Queue
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
    }
}
