class Solution {
    public int solve(int[] inventory, int orders) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Insert elements in the heap
        for(int i: inventory){
            maxheap.add(i);
        }
        int sum = 0;
        while(orders--> 0){
            int t = maxheap.poll();
            sum+=t;
            maxheap.add(t-1);
        }
        return sum;
    }
}