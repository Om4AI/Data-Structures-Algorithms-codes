import java.util.*;

public class DFS_Traversal {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        // Adjacency Map/List
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        // Get the graph & fil adjacency list
        int n = s.nextInt(), m = s.nextInt();
        for(int i=0; i<n+1; i++){
            graph.put(i,new ArrayList<Integer>());
        }

        while(m-->0){
            int u = s.nextInt(), v = s.nextInt();
            List<Integer> temp = graph.get(u);
            temp.add(v);
            graph.put(u, temp);
        }

        List<Integer> traversal = dfs(graph,n,m,1);
        System.out.println("DFS Traversal: "+traversal);
    }

    public static List<Integer> dfs(HashMap<Integer,List<Integer>> graph, int n, int m,int start){
        int vis[] = new int[n+1];
        Stack<Integer> stk = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stk.push(start);
        vis[start] = 1;

        while(!stk.isEmpty()){
            int curr = stk.pop();
            List<Integer> nodes = graph.get(curr);
            for(int i: nodes){
                if(vis[i]!=1){
                    stk.push(i);
                    vis[i] = 1;
                }
            }
            res.add(curr);
        }
        return res;
    }
}
