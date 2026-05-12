/*
 * This recursive solution is sooo goodddddd
 * I fell in love because of the case where one node is the parent of other
 *
 * Example: 5 & 4 case from question, here the left tree will return 5 and
 *          we won't check beyond that. So, when it comes to teh root (3), it
 *          receives (5 & null) then according to case it returns 5.
 *
 *          So, this case, it is automatically assumed that the other element
 *          would be a child of the first element.
 *
 *
 * Well our first solution was also good, but required much more time.
 *
 * Note - A number will be returned only when we find p/q whose ancestor needs to be found
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Edge case
        if (root==null || root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Conditions
        if (left==null) return right;
        else if (right==null) return left;
        else return root;
    }
}



// --------------------- How a not so experienced programmer writes the solution - TLE ---------------------

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> plist = getAncestors(root, p.val);
//         List<TreeNode> qlist = getAncestors(root, q.val);

//         // Create a new set of the values from plist
//         HashSet<Integer> set = new HashSet<>();
//         for (int i=0; i<plist.size(); i++){
//             set.add(plist.get(i).val);
//         }

//         // Traverse throguh qlist and find first common element
//         for (int i=qlist.size()-1; i>=0; i--){
//             TreeNode curr_node = qlist.get(i);
//             if (set.contains(curr_node.val)) return curr_node;
//         }

//         return root;
//     }

//     public static List<TreeNode> getAncestors(TreeNode root, List<TreeNode> curr, int element){
//         // Base case
//         if (root==null || (root.val!=element && root.left==null && root.right==null)) return new ArrayList<>();
//         if (root.val==element){
//             curr.add(root);
//             return curr;
//         }

//         // General case
//         List<TreeNode> templeft = new ArrayList<>(curr);
//         templeft.add(root);
//         List<TreeNode> tempright = new ArrayList<>(curr);
//         tempright.add(root);
//         List<TreeNode> left = getAncestors(root.left, templeft, element);
//         List<TreeNode> right = getAncestors(root.right, tempright, element);

//         return left.size()>right.size()? left:right;
//     }
// }