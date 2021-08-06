// Using ArrayList & Arrays

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
//         Lists for distances & arrays
        List<Double> dist1 = new ArrayList();  //ArrayList to get first indexof distance
        double dist2[] = new double[points.length];
        int pts[][] = new int[points.length][2];
        int res[][] = new int[k][2];
        
//         Loop for getting distances
        for (int i=0; i<points.length; i++){
            double f = Math.sqrt((points[i][0])*(points[i][0]) + (points[i][1])*(points[i][1]));
            dist1.add(f);
            dist2[i] = f;
            pts[i][0] = points[i][0];
            pts[i][1] = points[i][1];
        }
        
//         Sort the dist2 array & get pairs corresponding
        Arrays.sort(dist2);
        for (int i=0; i<k; i++){
            int index = dist1.indexOf(dist2[i]);
            res[i][0] = pts[index][0];
            res[i][1] = pts[index][1];
//             Replace the element with -1
            dist1.set(index, -1d);
        }
        return res;
    }
}
