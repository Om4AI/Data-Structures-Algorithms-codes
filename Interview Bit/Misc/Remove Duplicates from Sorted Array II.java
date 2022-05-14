import java.util.*;
public class Solution {
    public int removeDuplicates(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int p=0;
        for(int i=0; i<arr.size(); i++){
            int n = arr.get(i);
            if(map.containsKey(n)){
                if(map.get(n)<2){
                    // Swap & increase the occurence count
                    int t = arr.get(p);
                    arr.set(p,n);
                    arr.set(i,t);
                    map.put(n, map.getOrDefault(n, 0)+1);
                    p++;
                }
            }else{
                // Swap & increase the occurence count
                int t = arr.get(p);
                arr.set(p,n);
                arr.set(i,t);
                map.put(n,1);
                p++;
            }
        }
        return p;
    }
}