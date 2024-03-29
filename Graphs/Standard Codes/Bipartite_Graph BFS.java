import java.util.*;
// Code by Om
public class Bipartite_Graph {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Get the number of nodes and edges
        System.out.println("Enter the number of nodes and edges: \n");
        int n = s.nextInt(), m = s.nextInt();

        // Create adjacency map & initialize with empty lists
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n+1; i++) map.put(i,new ArrayList<Integer>());

        System.out.println("Enter the edges: ");
        for(int i=0; i<m; i++){
            int u = s.nextInt(), v = s.nextInt();

            // Edge u->v 
            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u,temp);

            // Edge v->u
            temp = map.get(v);
            temp.add(u);
            map.put(v,temp);
        }

        if(isBipartite(map,n)) System.out.println("Graph is Bipartite");
        else System.out.println("Graph is NOT Bipartite");
    }

    public static boolean isBipartite(HashMap<Integer,List<Integer>> map, int n){
        // Initialize color array with -1
        int color[] = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0; i<n+1; i++){
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
