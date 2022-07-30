import java.util.*;
class SmallestInfiniteSet {
    HashSet<Integer> removed;
    PriorityQueue<Integer> minheap;
    int small;
    public SmallestInfiniteSet() {
        removed = new HashSet<>();
        minheap = new PriorityQueue<Integer>();
        small = 1;
    }
    
    public int popSmallest(){
        if(minheap.size()>0 && minheap.peek()<small){
            removed.add(minheap.peek());
            return minheap.poll();
        }else{
            removed.add(small);
            small++;
            return small-1;
        }
    }
    
    public void addBack(int n) {
        if(removed.contains(n)) {
            removed.remove(n);
            minheap.add(n);
        }
    }
}