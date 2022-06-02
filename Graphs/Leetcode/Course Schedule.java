import java.util.*;
class Solution { 
    public boolean canFinish(int n, int[][] pre) {

        // Initializations
        // Create Adjacecncy HashMap from prereq
        int indegree[] = new int[n];
        List<Integer> topo = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++) map.put(i, new ArrayList<>());
        buildMap(map,pre,n,indegree);

        

        // --------------Topological sort start---------------
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0) q.add(i);
        }
        BFSTopo(map,q,indegree,n,topo);

        return (topo.size()==n)?true: false; 
    }

    public static void buildMap(HashMap<Integer, List<Integer>> map,int[][] pre, int n, int[] indegree){
        for(int i=0; i<pre.length; i++){
            int v = pre[i][0], u = pre[i][1];
            
            List<Integer> temp = map.get(u);
            temp.add(v);
            indegree[v]+=1;
            map.put(u, temp);
        }
    }

    public static void BFSTopo(HashMap<Integer, List<Integer>> map,Queue<Integer> q, int[] indegree, int n, List<Integer> topo){
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            List<Integer> nodes = map.get(node);

            for(int i: nodes){
                if(indegree[i]>0){
                    indegree[i]--;
                    if(indegree[i]==0) q.add(i);
                }
            }
        }
    }
}