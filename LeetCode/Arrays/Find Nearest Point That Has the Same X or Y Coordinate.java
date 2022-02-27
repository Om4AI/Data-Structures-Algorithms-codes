class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int d = Integer.MAX_VALUE, index = -1;
        for(int i=0; i<points.length; i++){
            if(points[i][0]==x || points[i][1]==y){
                int t = Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(t<d){
                    d = t;
                    index = i;
                }
            }
        }
        return index;
    }
}