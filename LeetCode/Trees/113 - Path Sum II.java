// Approach -
// Here we need to use static variables for storing the paths and the target sum
// For every node do the following -
//      1. Check for edge cases, check if its a leaf node and if so then check for targetSum
//      2. Never modify the currPath and currSum variables directly since they get returned
//      3. When doing a function call, directly send the updated currSum and currPath

class Solution {
    static int target_sum = 0;
    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target_sum = targetSum;
        res = new ArrayList<>();
        getPathsToSum(root, 0, new ArrayList<>());
        return res;
    }

    void getPathsToSum(TreeNode root, int currSum, List<Integer> currPath){
        // Edge case
        if (root==null) return;
        if (root.left==null && root.right==null){
            if ((currSum+root.val) == target_sum){
                List<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                res.add(temp);
            }
            return;
        }

        // Current node
        List<Integer> temp = new ArrayList<>(currPath);
        temp.add(root.val);
        getPathsToSum(root.left, currSum+root.val, temp);
        getPathsToSum(root.right, currSum+root.val, temp);
    }
}