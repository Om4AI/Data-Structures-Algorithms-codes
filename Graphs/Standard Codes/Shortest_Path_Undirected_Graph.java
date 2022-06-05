import java.util.*;
// Code by Om

public class Shortest_Path_Undirected_Graph {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter number of nodes & edges & source: ");
        int n = s.nextInt(), m = s.nextInt(), source = s.nextInt();

        HashMap<Integer, List<Integer>> map = constructMap(n,m);
        int res[] = findShortestPaths(map,n,source);

        // Result Display
        System.out.println("\nShortest distancs to each node: ");
        for(int i=0; i<res.length; i++){
            System.out.println(i+": "+res[i]);
        }
    }


    public static int[] findShortestPaths(HashMap<Integer, List<Integer>> map, int n, int source){
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Initialize the shortest path process
        q.add(source);
        dist[source] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> nodes = map.get(node);
            int d = dist[node];

            for(int i: nodes){
                if(dist[i]>(d+1)){
                    dist[i]=d+1;
                    q.add(i);
                }
            }
        }
        return dist;
    }









    public static HashMap<Integer, List<Integer>> constructMap(int n, int m){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = s.nextInt(), v = s.nextInt();
            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u, temp);

            temp = map.get(v);
            temp.add(u);
            map.put(v, temp);
        }
        return map;
    }
}
