/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> inter) {
        int intervals[][] = new int[inter.size()][2];
        for(int k=0; k<inter.size(); k++){
            intervals[k][0] = inter.get(k).start;
            intervals[k][1] = inter.get(k).end;
        }
        
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
        
        // Create result with Interval class
        ArrayList<Interval> result = new ArrayList<>();
        for(int j=0; j<res.size(); j++){
            Interval obj = new Interval(res.get(j).get(0), res.get(j).get(1));
            result.add(obj);
        }
        return result;
    }
}
