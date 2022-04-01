class Solution{
    ArrayList <Integer> nearlySorted(int arr[], int num, int k){
        ArrayList<Integer> res = new ArrayList<>();
        // Min heap creation
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        // Add elements to minheap & pop the top element into the result
        for(int i=0; i<arr.length; i++){
            minheap.add(arr[i]);
            if(minheap.size()>(k+1)){
                res.add(minheap.poll());
            }
        }
        // Add all of the remaining elements into the result
        while(!minheap.isEmpty()) res.add(minheap.poll());
        return res;
    }
}
