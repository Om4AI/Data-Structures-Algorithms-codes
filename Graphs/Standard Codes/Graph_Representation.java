// Graph Representation - Java
import java.util.*;
public class Graph_Representation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // n - Number of nodes & m - Number of edges
        int n = 5, m= 6;

        // Adjacency Matrix
        int mat[][] = new int[n+1][n+1];

        // Initialize with 0s'
        for(int i=0; i<n+1; i++){
            Arrays.fill(mat[i],0);
        }

        // Accept the edges and fill the matrix
        System.out.println("Enter the edges start and end points: \n");
        for(int i=0; i<m; i++){
            int u = s.nextInt();
            int v = s.nextInt();
            mat[u][v] = 1;
        }

        // Print the Adjacency Matrix
        System.out.println("\nAdjacency Matrix -\n");
        for(int i=0; i<n+1; i++){
            for(int j= 0; j<n+1; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
