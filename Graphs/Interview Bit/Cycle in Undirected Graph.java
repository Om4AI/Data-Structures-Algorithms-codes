public class Solution {
    public int solve(int n, int[][] edges){

        // Create Adjacency map
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n+1; i++) graph.put(i,new ArrayList<Integer>());

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];

            // u->v edge
            List<Integer> temp = graph.get(u);
            temp.add(v);
            graph.put(u,temp);

            // v->u edge
            temp = graph.get(v);
            temp.add(u);
            graph.put(v,temp);
        }
        
        // Create visited array
        boolean vis[] = new boolean[n+1];
        Arrays.fill(vis,false);
        
        // Traverse all the nodes to take care of any components if present
        for(int i=1; i<n+1; i++){
            if(vis[i]==false){
                if(checkForCycle(graph,vis,i,-1)) return 1;
            }
        }

        return 0;
    }

    public static boolean checkForCycle(HashMap<Integer,List<Integer>> graph, boolean vis[], int node, int parent){
        vis[node] = true;
        for(int n: graph.get(node)){
            // Adjacent node is not visited
            if(vis[n] == false){
                if(checkForCycle(graph,vis,n,node)) return true;
            }else if(vis[n]==true && n!=parent) return true;
        }
        return false;
    }
}
