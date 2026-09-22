// Greedy approach - We add the new interval to the list of intervals
// Later we move through intervals to merge the overlapping intervals

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        boolean added = false;
        List<List<Integer>> l = new ArrayList<>();
        // Base case
        if (n==0){
            int[][] res = {{newInterval[0], newInterval[1]}};
            return res;
        }

        // Insert the new interval inside the array
        for (int i=0; i<n; i++){
            if (newInterval[0]<=intervals[i][0] && added==false){
                l.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
                l.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
                added = true;
            }else{
                l.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            }
        }
        if (added==false) l.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));

        // The new interval needs to be insertex at the newIntPos index
        // Merge the intervals
        List<List<Integer>> res = new ArrayList<>();
        int startTime = Integer.MAX_VALUE, endTime = Integer.MIN_VALUE, p = 0;
        while (p<n+1){
            int currStart = l.get(p).get(0), currEnd = l.get(p).get(1);
            // Condition - Overlapping interval
            if (currStart <= endTime){
                startTime = Math.min(startTime, currStart);
                endTime = Math.max(endTime, currEnd);
            }else if (currStart > endTime){ // Non overlapping interval
                // Add interval to the list
                if (p>0) res.add(new ArrayList<>(List.of(startTime, endTime)));
                startTime = currStart;
                endTime = currEnd;
            }
            p++;
        }
        if (startTime!=Integer.MAX_VALUE && endTime!=Integer.MIN_VALUE) res.add(new ArrayList<>(List.of(startTime, endTime)));
        // Create the resultant array
        int[][] resArr = new int[res.size()][2];
        for (int i=0; i<res.size(); i++){
            resArr[i][0] = res.get(i).get(0);
            resArr[i][1] = res.get(i).get(1);
        }
        return resArr;
    }
}