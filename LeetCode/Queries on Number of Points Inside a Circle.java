class Solution {
    public int[] countPoints(int[][] p, int[][] q) {
        int res[] = new int[q.length];
        for (int i=0; i<q.length; i++){
            int cx = q[i][0], cy = q[i][1], r=q[i][2], count =0;
            for (int j=0; j<p.length; j++){
                int x = p[j][0], y = p[j][1];
                if (Math.sqrt(Math.pow((x-cx), 2)+Math.pow((y-cy), 2)) <= r){count++;}
            }
            res[i] = count;
        }
        return res;
    }
}
