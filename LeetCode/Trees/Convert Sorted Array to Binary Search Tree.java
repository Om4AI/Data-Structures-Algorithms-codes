// BST Implementation (Recursion)

class Solution {

    static TreeNode insert_val(int nums[], int l, int h){
        int mid = (l+h)/2;
        if (l==h){
            return new TreeNode(nums[l]);
        }else if (l>h){
            return null;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert_val(nums, l, mid-1);
        root.right = insert_val(nums, mid+1, h);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length/2;
        if (nums.length==0) return null;
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = insert_val(nums, 0, mid-1);
        root.right = insert_val(nums, mid+1, nums.length-1);
        return root;
    }
}
