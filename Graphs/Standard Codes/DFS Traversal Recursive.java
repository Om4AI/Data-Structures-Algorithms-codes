class Solution{
    public List<Integer> DFSOfGraph(int n, List<List<Integer>> adj){
        List<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[n+1];
        
        // For taking care of all components
        for(int i=1; i<n+1; i++){
            if(!vis[i]) DFS(i,adj,n,res);
        }
        return res;
    }

    public static void DFS(int node, List<List<Integer>> adj, int n, List<Integer> res){
        // Add the node to the result
        res.add(node);
        vis[node] = true;

        // Recusrive calls
        for(int i: adj.get(node)){
            if(!vis[i]) DFS(i,adj,n,res);
        }
    }
}
