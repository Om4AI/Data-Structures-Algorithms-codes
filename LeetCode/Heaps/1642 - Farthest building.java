/*
 * Heaps - Can be implemented in Java using Priority Queue
 * 
 * Min Heap - Implemented as a default option by PriorityQueue
 * Max Heap - Need to use Collections.reverseOrder() for implementation
 */

import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int n = heights.length;
        int diff[] = new int[n-1];

        // Fill the differences array
        for (int i=0; i<n-1; i++){
            if (heights[i]>=heights[i+1]){
                diff[i] = 0;
            }else{
                diff[i] = heights[i+1]-heights[i];
            }
        }
        
        // Traverse through the difference array
        for (int i=0; i<n-1; i++){
            int curr = diff[i];

            if (curr>0){
                // Use Ladders
                if (ladders>0){
                    min_heap.add(curr);
                    ladders--;
                }
                // Bricks
                else{
                    if (!min_heap.isEmpty()){
                        if (curr>=min_heap.peek() && bricks>=min_heap.peek()){
                            bricks-=min_heap.poll();
                            min_heap.add(curr);
                        }else if (curr<min_heap.peek() && bricks>=curr){
                            bricks-=curr;
                        }else{
                            return i;
                        }
                    }else{
                        if (bricks>=curr){
                            bricks-=curr;
                        }else return i;
                    }
                }
            }
        }
        return n-1;
    }
}