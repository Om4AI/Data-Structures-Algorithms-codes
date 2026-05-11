public class Solution {
    static int target_sum = 0;
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        target_sum = targetSum;
        res = new ArrayList<>();
        getPathsToSum(root, 0, new ArrayList<>());
        return res;
    }

    void getPathsToSum(TreeNode root, int currSum, ArrayList<Integer> currPath){
        // Edge case
        if (root==null) return;
        if (root.left==null && root.right==null){
            if ((currSum+root.val) == target_sum){
                ArrayList<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                res.add(temp);
            }
            return;
        }

        // Current node
        ArrayList<Integer> temp = new ArrayList<>(currPath);
        temp.add(root.val);
        getPathsToSum(root.left, currSum+root.val, temp);
        getPathsToSum(root.right, currSum+root.val, temp);
    }
}
