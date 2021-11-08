class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, res, path, 0);
        return res;
    }

    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int index){

        // Original path list 
        path.add(index);
        // Append a copy of the path to result list so that it doesn't change
        if (index == graph.length-1) res.add(new ArrayList<Integer>(path));
        else
            // For every connected node, call the dfs method
            for (int i: graph[index]) dfs(graph, res, path, i);
            
        // Restore the list back to as it was before adding the current index
        path.remove(path.size()-1);
    }
}
