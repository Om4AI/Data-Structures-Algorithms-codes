import java.util.Scanner;

public class Method_overloading {

    static void sumer(int arr[][], int m, int n){
        int sum = 0;
        for (int i=0;i<m; i++){
            for (int j=0;j<n;j++){
                sum += arr[i][j];
            }
        }
        System.out.println("\n\nThe sum of the integer 2D array is: "+sum+"\n");
    }

    static void sumer(float arr[][], int m, int n){
        float sum = 0f;
        for (int i=0;i<m; i++){
            for (int j=0;j<n;j++){
                sum += arr[i][j];
            }
        }
        System.out.println("\n\nThe sum of the float 2D array is: "+sum+"\n");
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter the dimensions of the matrix: ");
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println("\nEnter the type of input:\n1.Integer\n2.Float\n\n");
        int c = s.nextInt();
        if (c==1){
            int arr1[][] = new int[m][n];
            System.out.println("\nEnter the Integer numbers matrix: \n");
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    arr1[i][j] = s.nextInt();
                }
            }
            sumer(arr1,m,n);
        }
        else{
            float arr2[][] = new float[m][n];
            System.out.println("\nEnter the Floating numbers matrix: \n");
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    arr2[i][j] = s.nextFloat();
                }
            }
            sumer(arr2,m,n);
        }
    }
}
