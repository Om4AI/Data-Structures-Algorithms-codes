/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        // Edge case - Single Tree Node
        if (root.left==null && root.right==null){
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        return traverseBT(root, map);
    }



    public static int traverseBT(TreeNode root, HashMap<Integer, Integer> map){
        int total_palindromes = 0;
        
        // Insert value in HashMap
        if (map.containsKey(root.val)){
            map.remove(root.val);
        }else{
            map.put(root.val, 1);
        }

        // Leaf node - Dictionary palindrome check
        if (root.left==null && root.right==null){
            return map.size()<=1 ? 1:0;
        }

        // General case
        HashMap<Integer, Integer> copy = new HashMap<>();
        copy.putAll(map);
        if (root.left!=null){
            total_palindromes += traverseBT(root.left, copy);
        }
        if (root.right!=null){
            total_palindromes += traverseBT(root.right, map);
        }

        return total_palindromes;
    }
}