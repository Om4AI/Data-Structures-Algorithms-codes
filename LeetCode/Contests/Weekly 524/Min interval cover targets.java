import java.util.*;

class Solution {
    public int minSelection(int[][] availableIntervals, int[][] targetIntervals) {
        Arrays.sort(targetIntervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        Arrays.sort(availableIntervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        int n = availableIntervals.length, m = targetIntervals.length;

        // Find overlapping intervals
        int s = targetIntervals[0][0], e = targetIntervals[0][1];
        List<List<Integer>> ti = new ArrayList<>();
        for (int i=1; i<m; i++){
            int ts = targetIntervals[i][0], te = targetIntervals[i][1];
            if (ts<=e){
                if (te>=e) e = te;
            }else if (ts>e){
                ti.add(new ArrayList<>(List.of(s,e)));
                s = ts;
                e = te;
            }
        }
        ti.add(new ArrayList<>(List.of(s,e)));


        s = availableIntervals[0][0];
        e = availableIntervals[0][1];
        List<List<Integer>> ai = new ArrayList<>();
        for (int i=1; i<n; i++){
            int ts = availableIntervals[i][0], te = availableIntervals[i][1];
            if (ts<=e){
                if (te>=e) e = te;
            }else if (ts>e){
                ai.add(new ArrayList<>(List.of(s,e)));
                s = ts;
                e = te;
            }
        }
        ai.add(new ArrayList<>(List.of(s,e)));
        System.out.println(ti);
        System.out.println(ai);
        return 1;
    }
}