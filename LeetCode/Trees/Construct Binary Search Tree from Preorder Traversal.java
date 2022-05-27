import java.util.*;
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        
        // Convert preorder to HashMap & Get inorder
        List<Integer> inorder= new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<preorder.length; i++){
            inorder.add(preorder[i]);
            map.put(preorder[i],i);
        }
        Collections.sort(inorder);

        // Call the tree creation function
        return createPreInTree(preorder,inorder,map);
    }

    public static TreeNode createPreInTree(int[] preorder, List<Integer> inorder, HashMap<Integer, Integer> map){
        int index = Integer.MAX_VALUE, val = 0;

        // Base case
        if(inorder.size()==0) return null;

        // Find the root node's value using its index values
        for(int el: inorder){
            int tindex = map.get(el);
            if(tindex<index){
                index = tindex;
                val = el;
            }
        }
        // Create new root node using the value found earlier
        TreeNode root = new TreeNode(val);

        root.left = createPreInTree(preorder,inorder.subList(0,inorder.indexOf(val)),map);
        root.right = createPreInTree(preorder,inorder.subList(inorder.indexOf(val)+1, inorder.size()),map);

        return root;

    }
}