import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((a,b)->(b[0]-a[0]));

        for (int n: arr){
            int diff = Math.abs(x-n);
            int[] temp = new int[2];
            temp[0] = diff;
            temp[1] = n;
            // Main conditions for inserting into the Heap
            if(max_heap.size()<k) max_heap.add(temp);
            else if(max_heap.peek()[0]>diff || (max_heap.peek()[0] == diff && max_heap.peek()[1]>n)){
                max_heap.poll();
                max_heap.add(temp);
            }
            if(max_heap.size()>k) max_heap.poll();
        }

        while(!max_heap.isEmpty()){
            int[] a = max_heap.poll();
            res.add(a[1]);
        }
        Collections.sort(res);
        return res;
    }
}