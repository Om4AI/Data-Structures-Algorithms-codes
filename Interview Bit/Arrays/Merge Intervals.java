import java.util.*;

class Solution {
    public static List<List<Integer>> res;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        res = new ArrayList<>();
        int n = intervals.length;
        int s = newInterval[0], e = newInterval[1];

        // Intervals empty
        if(n==0){
            int result[][] = new int[1][2];
            result[0][0] = s;
            result[0][1] = e;
            return result;
        }

        // Find the start of the interval
        for(int i=0; i<n; i++){
            int si = intervals[i][0], ei = intervals[i][1];

            if(s>ei) continue;
            else if(s>=si && s<=ei){
                s = Math.min(s,si);
                e = Math.max(e,ei);
                break;
            }
            else if(s<si) break;
        }

        // Find the end point of intervals
        for(int i=n-1; i>=0; i--){
            int si = intervals[i][0], ei = intervals[i][1];

            if(e<si) continue;
            else if(e>=si && e<=ei){
                e = Math.max(e,ei);
            }else if(e>ei || e<intervals[0][0]) break;
        }

        // Create final answer
        // Edge cases: Before and After intervals
        int i=0;

        if(e<intervals[0][0]){
            insertInterval(s, e);
            insertAfter(i,intervals);
        }else if(s>intervals[n-1][1]){
            insertAfter(i,intervals);
            insertInterval(s, e);
        }else{
            for(i=0; i<n; i++){
                int si = intervals[i][0], ei = intervals[i][1];

                if(s>ei){
                    insertInterval(si, ei);
                }
                else if((s<si) || (s>=si && s<=ei)){
                    insertInterval(s, e);
                    i = modifyIndex(i,s,e,intervals);
                    insertAfter(i, intervals);
                    break;
                }
            }
        }
        

        int result[][] = new int[res.size()][2];
        for(int j=0; j<res.size(); j++){
            result[j][0] = res.get(j).get(0);
            result[j][1] = res.get(j).get(1);
        }
        return result;
    }


    // Function 1
    public static void insertInterval(int s, int e){
        List<Integer> l = new ArrayList<>();
        l.add(s);
        l.add(e);
        res.add(l);
    }

    // Function 2
    public static void insertAfter(int m, int[][] arr){
        for(int i=m; i<arr.length; i++) insertInterval(arr[i][0], arr[i][1]);
    }

    // Function 3
    public static int modifyIndex(int m, int s, int e, int[][] arr){
        int i = m;
        for(i=m; i<arr.length; i++){
            int ei = arr[i][1];
            if(ei<=e) continue;
            else if(ei>e) return i;
        }
        return i;
    }
}
