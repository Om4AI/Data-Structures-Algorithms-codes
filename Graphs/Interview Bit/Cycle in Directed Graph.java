import java.util.*;
public class Solution {
    public int solve(int n, int[][] edges){
        // n - Number of nodes
        // Adjacency Map
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<n+1; i++) graph.put(i,new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            List<Integer> temp = graph.get(u);
            temp.add(v);
            graph.put(u, temp);
        }

        // Initialize the visited array
        int vis[] = new int[n+1];
        int dfsvis[] = new int[n+1];

        // Check cycle for every node (Components are handled)
        for(int i=1; i<n+1; i++){
            if(vis[i]==0){
                if(checkForCycle(i,-1,graph,vis,dfsvis)) return 1;
            }
        }
        return 0;
    }

    public static boolean checkForCycle(int node, int parent, HashMap<Integer, List<Integer>> graph, int[] vis, int[] dfsvis){
        vis[node] = 1;
        dfsvis[node] = 1;

        for(int n:graph.get(node)){
            if(vis[n]==0){
                if(checkForCycle(n,node,graph,vis,dfsvis)) return true;
            }
            // We reached the same node in the current traversal(dfsvis[node]==1) thus cycle detected
            // dfsvis - Indicates if the node is visited in the current DFS traversal
            else if(vis[n]==1 && dfsvis[n]==1) return true;
        }
        // Current traversal is over and no cycle was found
        dfsvis[node] = 0;
        return false;
    }
}
