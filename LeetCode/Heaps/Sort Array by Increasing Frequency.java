import java.util.*;
class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a new hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+1);

        // Create a MinHeap
        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b)->((a[1] == b[1]) ? b[0] - a[0] : a[1]-b[1]));

        // Put the elements into the Heap
        for(int k: map.keySet()){
            int t[] = new int[2];
            t[0] = k;
            t[1] = map.get(k);
            if(!minh.isEmpty()){
                int occ2 = map.get(k);
                int occ1 = minh.peek()[1];
                if(occ1==occ2 && k<minh.peek()[0]){
                    minh.add(t);
                }else minh.add(t);
            }else minh.add(t);            
        }
        
        List<Integer> l= new ArrayList<>();
        int res[] = new int[nums.length];
        while(!minh.isEmpty()){
            int[] temp = minh.poll();
            l = add_els(l,temp[0],temp[1]);
        }
        for(int i=0; i<l.size(); i++) res[i] = l.get(i);
        return res;
    }

    public static List<Integer> add_els(List<Integer> l, int el, int n){
        for(int i=0; i<n; i++)l.add(el);
        return l;
    }
}