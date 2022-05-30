// -----------------Interview Bit Format---------------------

import java.util.*;
public class Solution {

    public static int solve(int n, int[][] edges){

        // Create adjacency map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n+1; i++) map.put(i, new ArrayList<Integer>());
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u, temp);

            temp = map.get(v);
            temp.add(u);
            map.put(v, temp);
        }

        // Create visited array
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        // Check number of BFS traversals
        int c = 0;

        // Check BFS traversal for all nodes
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                c++;
                BFS(map,n,visited,i);
            }
        }

        return c;
    }

    public static void BFS(HashMap<Integer, List<Integer>> map, int n, boolean[] visited, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i: map.get(node)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            } 
        }
    }
}

// --------------------------------------------------------------------------------



// ----------------------------Local Test Format-----------------------------------
public class Connected_Components {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();

        int[][] edges = new int[m][2];
        for(int i=0; i<m; i++){
            edges[i][0] = s.nextInt();
            edges[i][1] = s.nextInt();
        }

        System.out.println(connectComponents(edges,n));
    }

    public static int connectComponents(int[][] edges, int n){

        // Create adjacency map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n+1; i++) map.put(i, new ArrayList<Integer>());
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            List<Integer> temp = map.get(u);
            temp.add(v);
            map.put(u, temp);

            temp = map.get(v);
            temp.add(u);
            map.put(v, temp);
        }

        // Create visited array
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        // Check number of BFS traversals
        int c = 0;

        // Check BFS traversal for all nodes
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                c++;
                BFS(map,n,visited,i);
            }
        }

        return c;
    }

    public static void BFS(HashMap<Integer, List<Integer>> map, int n, boolean[] visited, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i: map.get(node)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            } 
        }
    }
}

// --------------------------------------------------------------------------------
