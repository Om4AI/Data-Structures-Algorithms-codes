import java.util.*;
import java.io.*;

class Solution {
    public int minSetSize(int[] arr) {
        
        // Count occurrences of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num:arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        // Store occurrences in list
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int len = arr.length;
        int c = arr.length;
        int i=0;
        while (c>len/2){
            c -= list.get(i);
            i+=1;
        }
        return i;
    }
}
