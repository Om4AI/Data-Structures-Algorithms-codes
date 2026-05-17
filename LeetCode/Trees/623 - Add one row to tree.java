// Approach:
// Use Level-order traversal & for every node:
//      1. Check if the current depth is (required_depth-1)
//      2. If we are on the previous level, for every node in the queue - Add a new left and right node
//      3. Link the left and right nodes of actual node to the these newly added nodes
//      4. Increment the current depth counter
//      5. NOTE: Don't forget to reset the curr_depth counter at the beginning
//      6. Take care of the edge case (depth==1)

import java.util.*;

class Solution {
    static int curr_depth = 1;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Edge case: depth == 1
        if (depth==1){
            TreeNode new_node = new TreeNode(val);
            new_node.left = root;
            return new_node;
        }
        curr_depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            for (int i=0; i<n; i++){
                TreeNode curr = q.poll();
                if (curr_depth == depth-1){
                    // Add new row to tree
                    TreeNode new_left = new TreeNode(val);
                    new_left.left = curr.left;
                    curr.left = new_left;
                    q.add(new_left);

                    TreeNode new_right = new TreeNode(val);
                    new_right.right = curr.right;
                    curr.right = new_right;
                    q.add(new_right);
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            curr_depth += 1;
        }
        return root;
    }
}