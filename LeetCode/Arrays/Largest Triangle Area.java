class Solution {
    public double largestTriangleArea(int[][] arr) {
        double res = 0d;

        for(int i=0; i<arr.length-2; i++){
            int x1 = arr[i][0], y1 = arr[i][1];
            for(int j=i+1; j<arr.length-1; j++){
                int x2 = arr[j][0], y2 = arr[j][1];
                for(int k=j+1; k<arr.length; k++){
                    int x3 = arr[k][0], y3 = arr[k][1];

                    double area = 0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
                    res = Math.max(res, Math.abs(area));
                }
            }
        }
        return res;
    }
}
