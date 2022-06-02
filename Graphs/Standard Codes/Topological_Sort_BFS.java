// ---------------------------------Kahn's Algorithm--------------------------------------

import java.util.*;
public class Topological_Sort_BFS{
    static Scanner s = new Scanner(System.in);
    static List<Integer> topo = new ArrayList<>();

    public static void main(String[] args) {
        int n = s.nextInt(), m = s.nextInt(), st = s.nextInt();
        int indegree[] = new int[n+st];

        // Fill the indegree along with adjacency map
        HashMap<Integer, List<Integer>> map = buildAdjacencyMap(n,m,st,indegree);

        // Starting element insertion
        Queue<Integer> q = new LinkedList<>();
        for(int i=st; i<n+st; i++){
            if(indegree[i]==0) q.add(i);
        }

        // BFS Traversal
        BFS(q,n,map,indegree);
        System.out.println(topo);
    }

    public static void BFS(Queue<Integer> q, int n, HashMap<Integer, List<Integer>> map, int[] indegree){
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            List<Integer> nodes = map.get(node);

            for(int i:nodes){
                if(indegree[i]>0){
                    indegree[i]--;
                    if(indegree[i]==0) q.add(i);
                }                
            }
        }
    }


    // -----------------------------Helper for Local Execution----------------------------------
    public static HashMap<Integer, List<Integer>> buildAdjacencyMap(int n, int m, int st, int[] indegree){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=st; i<n+st; i++) map.put(i, new ArrayList<Integer>());

        for(int i=0; i<m; i++){
            int u = s.nextInt(), v = s.nextInt();

            List<Integer> temp = map.get(u);
            temp.add(v);
            indegree[v]+=1;
            map.put(u, temp);
        }
        return map;
    }

    
}
