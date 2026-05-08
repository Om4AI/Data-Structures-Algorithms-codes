// Approach -
// Think of the tree on a coordinate plane with the root node as (0,0)
//      1. The left leaf node would be (-1, 1): (x coordinate, height/level)
//      2. The right left node would be (1, 1)
//      3. Can be stored as -
//          {
//              0 (x coordinate/vertical): {
//                  1 (level): [2] (Priority Queue)
//              }
//          }
//      4. Use the static variable and DFS traversal to populate the table
//      5. Finally traverse this TreeMap and create the final resultant array list

// Some learnings -
//      1. HashMap doesn't sort the keys within BUT TreeMap sorts the keys
//      2. PriorityQueue sorts the elements within but if we use addAll then the order is removed INSTEAD use poll()

class Solution {
    static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root){
        map = new TreeMap<>();
        updateMap(root, 0, 0);

        // Construct the final ArrayList
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> vertical: map.values()){
            List<Integer> ver = new ArrayList<>();
            for (PriorityQueue<Integer> pq:vertical.values()){
                // ver.addAll(pq);
                while (!pq.isEmpty()) {
                    ver.add(pq.poll());
                }
            }
            res.add(ver);
        }
        return res;
    }

    void updateMap(TreeNode root, int x, int level){
        // Add entry for current root's value in map
        if (map.containsKey(x)){
            TreeMap<Integer, PriorityQueue<Integer>> vertical = map.get(x);
            if (vertical.containsKey(level)){
                vertical.get(level).add(root.val);
            }else{
                vertical.put(level, new PriorityQueue<>());
                vertical.get(level).add(root.val);
            }
        }else{
            TreeMap<Integer, PriorityQueue<Integer>> temp = new TreeMap<>();
            temp.put(level, new PriorityQueue<>());
            temp.get(level).add(root.val);
            map.put(x, temp);
        }

        // Left and right subtrees
        if (root.left != null) updateMap(root.left, x-1, level+1);
        if (root.right != null) updateMap(root.right, x+1, level+1);
    }
}