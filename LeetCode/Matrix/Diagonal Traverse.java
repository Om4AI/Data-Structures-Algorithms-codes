class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int u=1, i =0, j=0;
        List<Integer> res = new ArrayList<>();

        while(i!=m-1 || j!=n-1){
            // Traversing upwards
            if(u==1){
                while(j<=n-1 && i>=0){
                    res.add(mat[i][j]);
                    i--;
                    j++;
                }
                i++;
                j--;
                u=0;
            }
            // Traversing downwards
            else if(u==0){
                while(i<=m-1 && j>=0){
                    res.add(mat[i][j]);
                    j--;
                    i++;
                }
                i--;
                j++;
                u=1;
            }

            // Change values of i & j (Next Starting Point)
            // 0-0 case
            if(i==0 && j==0 && j+1<=n-1) j++;
            else if(i==0 && j==0) i++;

            // 1st Col & Last Row
            else if(j==0 && i+1<=m-1) i++;
            else if(j==0 && i+1>m-1) j++;
            else if(i==m-1) j++;

            // 1st row & Last Column
            else if(i==0 && j+1<=n-1) j++;
            else if(i==0 && j+1>n-1) i++;
            else if(j==n-1) i++;
        }

        // Add the last element of the matrix
        res.add(mat[m-1][n-1]);

        // Store result in an array
        int fr[] = new int[m*n];
        for(int k=0; k<m*n; k++) fr[k] = res.get(k);
        return fr;
    }
}
