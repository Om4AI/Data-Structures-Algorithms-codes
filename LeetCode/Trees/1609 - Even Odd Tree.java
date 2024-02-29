class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);

        for (int i=0; i<res.size(); i++){
            // Even level
            if (i%2==0){
                List<Integer> l = res.get(i);
                if (checkOddAscending(l)==false) return false;
            }
            // Odd level
            else{
                List<Integer> l = res.get(i);
                if (checkEvenDescending(l)==false) return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Every level in tree
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            res.add(level);
        }
        return res;
    }

    public static boolean checkOddAscending(List<Integer> l){
        if (l.get(0)%2==0) return false;
        int max = l.get(0);
        for(int i=1; i<l.size(); i++){
            int curr = l.get(i);
            // Odd number check
            if (curr%2==0) return false;

            // Ascending check
            if (curr<=max) return false;
            max = Math.max(max, curr);
        }
        return true;
    }

    public static boolean checkEvenDescending(List<Integer> l){
        if (l.get(0)%2!=0) return false;
        int min = l.get(0);
        for(int i=1; i<l.size(); i++){
            int curr = l.get(i);
            // Odd number check
            if (curr%2!=0) return false;

            // Ascending check
            if (curr>=min) return false;
            min = Math.min(min, curr);
        }
        return true;
    }
}