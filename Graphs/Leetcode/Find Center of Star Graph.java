// Non Graph Approach (Accepted)

class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
        }
        
        int n = edges.length;
        for(int k:map.keySet()){
            if(map.get(k)==n) return k;
        }
        return -1;
    }
}
