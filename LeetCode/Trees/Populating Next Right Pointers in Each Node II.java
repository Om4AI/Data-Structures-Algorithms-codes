import java.util.*;
class Solution {
    public Node connect(Node root){

        // Base case
        if(root==null) return root;

        // Construct tree from level order traversal
        levelOrderTree(root);
        return root;
    }


    public static void levelOrderTree(Node root){

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            while(n-->0){
                Node node = q.poll();
                // There is a node after this in the level
                if(q.peek()!=null && n!=0){
                    node.next=q.peek();
                }else{
                    node.next = null;
                }

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
    }
}