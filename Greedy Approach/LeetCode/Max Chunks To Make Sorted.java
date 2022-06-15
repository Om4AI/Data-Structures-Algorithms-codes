import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr){
        // Create a new MaxHeap
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Count the maximum chunks that can be made
        int c = 0, start = -1, n = arr.length;
        for(int i=0; i<n; i++){
            int curr = i;
            maxheap.add(arr[i]);
            
            // If (top=index & size=index-start)
            if(maxheap.peek()==i && maxheap.size()==(i-start)){
                c++;
                maxheap.clear();
                start = curr;
            }
        }
        return c;
    }
}