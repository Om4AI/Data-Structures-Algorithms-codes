// Greedy approach - Sort the intervals based on the end time (after creating custom objects)
// For every interval, check the start time and see if it is greater than the current stored end time

class Solution {
    static class interval{
        int start;
        int end;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        interval[] arr = new interval[n];
        // Create interval objects
        for (int i=0; i<n; i++){
            arr[i] = new interval();
            arr[i].start = intervals[i][0];
            arr[i].end = intervals[i][1];
        }
        // Sort the intervals - Based on ending times
        Arrays.sort(arr, Comparator.comparingInt(inter -> inter.end));

        // Loop through intervals to count the ones that can be included
        int currEnd = Integer.MIN_VALUE, resCount = 0;
        for (int i=0; i<n; i++){
            if (arr[i].start >= currEnd){
                resCount++;
                currEnd = arr[i].end;
            }
        }
        return n-resCount;
    }
}