import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<List<Integer>> res = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1], n = intervals.length;

        for(int i=0; i<n; i++){
            if(intervals[i][0]>=s && intervals[i][0]<=e) e = Math.max(intervals[i][1], e);
            else if(intervals[i][0]>e){
                res.add(new ArrayList<>(Arrays.asList(s,e)));
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        res.add(new ArrayList<>(Arrays.asList(s,e)));
        
        // Create 2D array
        int[][] arr = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            arr[i][0] = res.get(i).get(0);
            arr[i][1] = res.get(i).get(1);
        }
        return arr;
    }
}