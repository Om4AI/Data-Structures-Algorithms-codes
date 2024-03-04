import java.util.*;

class Solution {
    public String convert(String s, int m) {
        int x = s.length()/m;
        int n = x + (x)*(m-2) + 1;
        Character arr[][] = new Character[m][n];

        // Edge case
        if (m==1 || s.length()<m) return s;

        int i=-1, j=0, sp=0;
        int inserting_diagonal = 0, inserting_vertical=1;

        while(sp<s.length()){
            if (inserting_vertical==1){
                if (i==m-1){
                    inserting_diagonal = 1;
                    inserting_vertical = 0;
                }else{
                    i++;
                    arr[i][j] = s.charAt(sp);
                    sp++;
                }
            }else if (inserting_diagonal==1){
                if (i==0 || j==n-1){
                    inserting_vertical = 1;
                    inserting_diagonal = 0;
                }else{
                    i--;
                    j++;
                    arr[i][j] = s.charAt(sp);
                    sp++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i1=0; i1<m; i1++){
            for (int j1=0; j1<n; j1++){
                if (arr[i1][j1]!=null) sb.append(Character.toString(arr[i1][j1]));
            }
        }

        return sb.toString();
    }
}