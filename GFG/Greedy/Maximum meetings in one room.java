class Solution {
    static class room{
        int start;
        int end;
        int index;
    }

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // Create the objects from the arrays
        int n = s.length;
        room[] arr = new room[n];
        for (int i=0; i<n; i++){
            arr[i] = new room();
            arr[i].start = s[i];
            arr[i].end = f[i];
            arr[i].index = i;
        }

        // Sort the list of custom object using endTime & later using Index in case of a tie
        Arrays.sort(arr, Comparator.comparingInt((room r) -> r.end).thenComparingInt(r -> r.index));

        // Actual greedy logic - We start taking the meetings from the beginning since they are already sorted in lowest ending times
        ArrayList<Integer> order = new ArrayList<>();
        int currEnd = -1;
        for (int i=0; i<n; i++){
            if (arr[i].start>currEnd){
                currEnd = arr[i].end;
                order.add(arr[i].index+1);
            }
        }
        Collections.sort(order);
        return order;
    }
}