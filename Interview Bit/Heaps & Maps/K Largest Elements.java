public class Solution {
    public int[] solve(int[] arr, int k){
        // Largest elements - Min Heap
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            minheap.add(arr[i]);
            if(minheap.size()>k) minheap.poll();
        }

        int res[] = new int[k];
        int i =0;
        while(!minheap.isEmpty()){
            res[i] = minheap.poll();
            i++;
        }
        return res;
    }
}
