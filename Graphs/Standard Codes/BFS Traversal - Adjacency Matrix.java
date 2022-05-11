import java.util.*;
class BFS{
    public static void BFS(int[][] graph, int n, int s){
        
        // Initialization
        int vis[] = new int[n+1];
        Arrays.fill(vis,0);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = 1;
        List<Integer> res = new ArrayList<>();
    
        while(!q.isEmpty()){
            // Retrieve the current node
            int curr = q.poll();
            
            // Add all the connected nodes to Queue
            for(int i=0; i<n+1; i++){
                if(graph[curr][i]==1 && vis[i]==0){
                    q.add(i);
                    vis[i] = 1;
                }
            }
            res.add(curr);
        }
    
        // Result display
        System.out.println("\nBFS Traversal: \n");
        System.out.println(res);
    }
}