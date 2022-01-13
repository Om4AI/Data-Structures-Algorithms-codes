class Solution {
    public int findMinArrowShots(int[][] points) {
//         Sort using the end
        Arrays.sort(points, (a,b)-> {return a[1]>b[1]?1:-1;});
//         Pointers
        int aPosition = points[0][1];
        int aCount = 1;
//         Actual Loop
        for(int i=1; i<points.length; i++){
            if(aPosition>=points[i][0]) continue;
            aCount++;
            aPosition = points[i][1];
        }
        return aCount;
    }
}
