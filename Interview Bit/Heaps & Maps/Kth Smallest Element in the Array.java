public class Solution {
    public int kthsmallest(final int[] arr, int k){
        // Max Heap - Use the Collections.reverseOrder() to get implementation of Max Heap
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements to the heap
        for(int i=0; i<arr.length; i++){
            maxheap.add(arr[i]);
            if(maxheap.size()>k) maxheap.poll();
        }

        // Return the top element of the max heap
        return maxheap.peek();
    }
}
