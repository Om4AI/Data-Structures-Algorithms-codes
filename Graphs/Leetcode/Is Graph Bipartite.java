class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(i,new ArrayList<Integer>());
        
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j: graph[i]){
                temp.add(j);
            }
            map.put(i,temp);
        }
        return checkBipartite(map,n);
        
    }
    
    public static boolean checkBipartite(HashMap<Integer,List<Integer>> map, int n){
        // Initialize color array with -1
        int color[] = new int[n];
        Arrays.fill(color,-1);
        
        // Code to check Bipartite for all components
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(!BFScheck(map,i,color)) return false;
            }
        }
        return true;
    }
    
    public static boolean BFScheck(HashMap<Integer,List<Integer>> map, int sn, int[] color){
        // Initialize the queue with starting node value
        Queue<Integer> q = new LinkedList<>();
        q.add(sn);
        color[sn] = 0;

        // Actual loop
        while(!q.isEmpty()){
            int node = q.poll();

            // Go through all adjacent nodes
            for(int i: map.get(node)){
                if(color[i]==-1){
                    q.add(i);
                    color[i] = 1-color[node];
                }else{
                    if (color[node]==color[i]) return false;
                }
            }
        }
        return true;
    }
}