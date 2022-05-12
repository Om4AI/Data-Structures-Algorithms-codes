// Adjacency List Approach - Accepted
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        // Base case - 1 node
        if(n==1 || (source==destination)) return true;
        
        // Adjacency list method
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(i,new ArrayList<Integer>());

        // Fill the Adjacency List Map
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u, temp);

            temp = map.get(v);
            temp.add(u);
            map.put(v, temp);
        }

        // BFS traversal function call
        return BFS(map,n,source, destination);
    }

    public static boolean BFS(HashMap<Integer, List<Integer>> map, int n, int s, int d){
        // Declare the visited array
        int vis[] = new int[n];
        Arrays.fill(vis,0);

        // Initialize source node
        vis[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()){
            int curr = q.poll();

            // Add the connected nodes
            List<Integer> temp = map.get(curr);
            for(int node: temp){
                if(vis[node]==0){
                    q.add(node);
                    vis[node] = 1;
                    if(node==d) return true;
                }
            }
        }
        return false;
    }
}
