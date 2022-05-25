import java.util.*;
public class Cycle_Detection_using_BFS {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter - Number of nodes & Number of edges: \n");
        int n = s.nextInt(), m = s.nextInt();
        System.out.println("Enter "+ m +" edges: \n");
        
        // Create Adjacency Map
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n; i++)  map.put(i,new ArrayList<Integer>());

        for(int i=0; i<m; i++){
            int u = s.nextInt(), v = s.nextInt();
            addEdge(map,u,v);
            addEdge(map,v,u);
        }

        // Create visited array
        boolean vis[] = new boolean[n+1];
        Arrays.fill(vis,false);
        
        // Traverse each node from 1->8
        for(int i=1; i<=n; i++){
            if(vis[i]==false){
                if(cycleBFS(map,vis,i)){
                    System.out.println("Cycle Exists");
                    return;
                }
            }
        }
        System.out.println("Cycle does not exist");
    }


    // Cycle Detection using BFS
    public static boolean cycleBFS(HashMap<Integer, List<Integer>> map,boolean[] vis, int node){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{node,-1});
        vis[node] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            List<Integer> nodes = map.get(curr[0]);
            for(int n: nodes){
                if(vis[n]==false){
                    q.add(new int[]{n,curr[0]});
                    vis[n] = true;
                }else if(vis[n]==true && n!=curr[1]) return true;
            }
        }
        return false;
    }

    // Helper function to put
    public static void addEdge(HashMap<Integer, List<Integer>> map, int u, int v){
        List<Integer> temp = map.get(u);
        temp.add(v);
        map.put(u,temp); 
    }
}
