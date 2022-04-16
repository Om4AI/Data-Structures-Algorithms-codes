import java.util.*;
public class Solution {
    public int[] solve(int[][] arr){
        int res[] = new int[arr.length*arr[0].length];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                minheap.add(arr[i][j]);
            }
        }

        int p =0 ;
        while(!minheap.isEmpty()){
            res[p] = minheap.poll();
            p++;
        }
        return res;
    }
}
