import java.util.*;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        // Check for incoming edges in each node
        // LOGIC: Add all the nodes which don't have any incoming edge
        boolean incoming[] = new boolean[n];
        
        // Fill up the incoming array
        for(int i=0; i<edges.size(); i++){
            int v = edges.get(i).get(1);
            incoming[v] = true;
        }

        // Create result list
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!incoming[i]) res.add(i);
        }
        return res;
    }
}