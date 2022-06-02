import java.util.*;
public class Topological_Sort_DFS{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt(), m = s.nextInt(), st = s.nextInt();

        HashMap<Integer, List<Integer>> map = buildAdjacencyMap(n,m,st);

        Stack<Integer> stk = new Stack<>();
        int vis[] = new int[n+st];

        for(int i=st; i<n+st; i++){
            if(vis[i]==0){
                toposort(map,n,stk,vis,i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while(!stk.isEmpty()){
            topoOrder.add(stk.pop());
        }

        System.out.println(topoOrder);
    }

    public static HashMap<Integer, List<Integer>> buildAdjacencyMap(int n, int m, int st){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=st; i<n+st; i++) map.put(i, new ArrayList<Integer>());

        for(int i=0; i<m; i++){
            int u = s.nextInt(), v = s.nextInt();

            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u, temp);
        }
        return map;
    }

    public static void toposort(HashMap<Integer, List<Integer>> map, int n, Stack<Integer> stk, int[] vis, int node){
        vis[node] = 1;
        List<Integer> nodes = map.get(node);

        for(int i: nodes){
            if(vis[i]==0){
                toposort(map,n,stk,vis,i);
            }
        }

        // DFS complete then push element into stack
        stk.push(node);
    }
}
