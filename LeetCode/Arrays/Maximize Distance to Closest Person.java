// Brute Force Approach
import java.util.*;
class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<seats.length; i++){
            if(seats[i]==1) list.add(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<seats.length; i++){
            if(seats[i]==0){
                int dist = get_min_dist(list, i);
                map.put(i, dist);
            }
        }
        int max=Integer.MIN_VALUE, max_index=0;
        for(int k:map.keySet()){
            int val = map.get(k);
            if(val>max){
                max = val;
                max_index = k;
            }
        }
        return max;
    }

    public static int get_min_dist(List<Integer> list, int index){
        int min = Integer.MAX_VALUE;
        for(int n: list){
            min = Math.min(min, Math.abs(index-n));
        }
        return min;
    }
}


// Optimized Approach
import java.util.*;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1, future =0, max = 0;

        for(int i=0; i<n; i++){
            if(seats[i]==1) prev = i;
            else{
                // Findind the next person to right
                while(future<n && seats[future]==0 || future<i) future++;

                int left = prev==-1? n: i-prev;
                int right = future==n? n: future-i;
                
                // Max = max(Maximum till now, Closest out of left & right person)
                max = Math.max(max, Math.min(left, right));
            }
        }
        return max;
    }
}
