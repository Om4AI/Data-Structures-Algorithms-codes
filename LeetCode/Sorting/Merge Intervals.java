// Process explained below (see commented lines)

import java.util.*;
class Solution {
  
//   Merge the intervals
    static List<List<Integer>> merge_intervals(List<List<Integer>> arr){
        for (int i=0; i<arr.size()-1; i++){
            // Elements are arr.get(i) & arr.get(i+1)
            if (arr.get(i).get(1) >= arr.get(i+1).get(0)){
                List<Integer> merged = new ArrayList();
                merged.add(arr.get(i).get(0));
                merged.add(Math.max(arr.get(i).get(1), arr.get(i+1).get(1)));
                arr.remove(i+1);
                arr.set(i, merged);
            }
        }
        return arr;
    }
  
//   Check if the intervals are merged and check if they can be merged further
    static int is_merged(List<List<Integer>> arr){
        int f = 1;
        for (int i=0; i<arr.size()-1; i++){
            if (arr.get(i).get(1) >= arr.get(i+1).get(0)) f=0;
        }
        return f;
    }

    public int[][] merge(int[][] intervals) {
        // Prepare ArrayList of elements
        List<List<Integer>> arr  = new ArrayList();
        for (int i=0; i<intervals.length; i++){
            List<Integer> temp = new ArrayList();
            for (int j=0; j<intervals[i].length; j++){
                temp.add(intervals[i][j]);
            }
            arr.add(temp);
        }
        // Sort the ArrayList
        for (int i=0; i<arr.size()-1; i++){
            for (int j=i+1; j<arr.size(); j++){
                if (arr.get(i).get(0) > arr.get(j).get(0)){
                    List<Integer> t = new ArrayList<>();
                    t = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, t);
                }
            }
        }
        // Keep on merging & checking until no more merging can happen
        int f = 0;
        while (f!=1){
            arr = merge_intervals(arr);
            f = is_merged(arr);
        }
        // Convert into a 2D array
        int res[][] = new int[arr.size()][2];
        for (int i=0; i<arr.size(); i++){
            res[i][0] = arr.get(i).get(0);
            res[i][1] = arr.get(i).get(1);
        }
        return res;
    }
}
