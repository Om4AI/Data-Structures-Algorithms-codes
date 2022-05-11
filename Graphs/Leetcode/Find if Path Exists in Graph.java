// Using Adjacency Matrix - Memory Limit Exceeded

import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        // Workflow - Find the BFS from the source
        // If Destination exists in the BFS then True

        // Adjacency matrix
        int mat[][] = new int[n][n];
        for(int i=0; i<n; i++)Arrays.fill(mat[i],0);

        // Modify the matrix according to undirected graph edges
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            mat[u][v] = 1;
            mat[v][u] = 1;
        } 

        // Find the BFS for source
        List<Integer> bfs = BFS(mat,n,source);
        return bfs.contains(destination);
    }

    public static List<Integer> BFS(int[][] graph, int n, int s){

        // Initialization
        int vis[] = new int[n];
        Arrays.fill(vis,0);

        // Starting node initialization
        vis[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0; i<n; i++){
                if(graph[curr][i]==1 && vis[i]==0){
                    q.add(i);
                    vis[i] = 1;
                }
            }
            res.add(curr);
        }
        return res;
    }
}