import java.util.*;
public class Beautiful_Matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int mat[][] = new int[5][5];
        int x=0, y=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                mat[i][j] = s.nextInt();
                if(mat[i][j]==1){
                    x = i+1;
                    y=j+1;
                }
            }
        }
        System.out.println(Math.abs(3-x)+Math.abs(3-y));
    }
}
