import java.util.*;

public class Solution {
    public int solve(int n, int[][] edges){

        // Create adjacency list
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n; i++) map.put(i,new ArrayList<Integer>());
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            List<Integer> t= map.get(u);
            t.add(v);
            map.put(u,t);
        }

        return BFS(n,map);
    }

    public static int BFS(int n, HashMap<Integer,List<Integer>> map){
        // Initialize
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n+1];
        Arrays.fill(vis,0);
        q.add(1);
        vis[1] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> temp = map.get(curr);
            for(int node: temp){
                if(vis[node]==0){
                    q.add(node);
                    vis[node] = 1;
                    if(node==n) return 1;
                }
            }
        }
        return 0;
    }
}
