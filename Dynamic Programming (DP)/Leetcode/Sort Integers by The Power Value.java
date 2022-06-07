import java.util.*;

// Class for Max heap to insert pair(Number, Power)
class Item{
    int num;
    int power;

    Item(int n, int p){
        num = n;
        power =p;
    }
}

class Solution {
    public int getKth(int lo, int hi, int k) {
        
        // Initialization for memoization
        HashMap<Integer, Integer> t = new HashMap<>();
        
        // Max-Heap for sorting as we find new powers
        PriorityQueue<Item> maxheap = new PriorityQueue<>((a,b)-> (a.power==b.power)? (b.num-a.num):(b.power-a.power));
        
        // Loop to find powers and insert into Max heap
        for(int i=lo; i<=hi; i++){
            Item obj = new Item(i,getPower(i,t));

            maxheap.add(obj);

            // Keep only the starting K elements
            if(maxheap.size()>k){
                maxheap.remove();
            }
        }
        
        // Top element is the Kth element in ascending order
        return maxheap.remove().num;
    }
    
    
    public static int getPower(int n,HashMap<Integer, Integer> t){
        // Base case
        if(n==1) return 0;

        // Memoization
        if(t.containsKey(n)) return t.get(n);

        if(n % 2==0){
            int power = 1 + getPower(n/2,t);
            t.put(n,power);
            return t.get(n);
        }else{
            int power = 1 + getPower((3*n) + 1,t);
            t.put(n,power);
            return t.get(n);
        }
    }
}