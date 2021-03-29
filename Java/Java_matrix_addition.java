import java.util.*;
import java.math.*;

public class Java_matrix_addition {

    static int[][] accept(int mat[][],int m,int n){
        Scanner s = new Scanner(System.in);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                mat[i][j] = s.nextInt();
            }
        }
        return mat;
    }

    static void printmatrix(int mat[][], int m, int n){
        // Print the matrix
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the dimensions of the matrix: ");
        int m = s.nextInt();
        int n = s.nextInt();
        int mat1[][] = new int[m][n];
        int mat2[][] = new int[m][n];
        System.out.println("Enter the elements of the matrices, rowwise: ");
        System.out.println("\nEnter the first matrix: ");
        mat1 = accept(mat1,m,n);
        System.out.println("\nEnter the second matrix: ");
        mat2 = accept(mat2,m,n);

        // Resultant calculate
        int res[][] = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                res[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        System.out.println("\n\nThe resultant matrix is: ");
        printmatrix(res,m,n);
    }
}
