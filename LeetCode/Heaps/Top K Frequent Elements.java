import java.util.*;

class Solution {
    public int[] topKFrequent(int[] arr, int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count Occurences of each element
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        // Create and fill the MinHeap
        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int k: map.keySet()){
            int t[] = new int[2];
            t[0] = k;
            t[1] = map.get(k);
            minh.add(t);

            if(minh.size()>num)minh.poll();
        }

        // Return the elements in the heap
        int res[] = new int[num];
        for(int i=0; i<num; i++){
            int t[] = minh.poll();
            res[i] = t[0];
        }
        return res;
    }
}
