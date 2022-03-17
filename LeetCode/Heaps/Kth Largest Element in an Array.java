class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

        // For every element we add the element to PriorityQueue
        for(int i=0; i<arr.length; i++){
            minheap.add(arr[i]);
            if(minheap.size()>k) minheap.poll();    
        }
        
        // Return the top of the heap (Minimum heap)
        return minheap.peek();
    }
}