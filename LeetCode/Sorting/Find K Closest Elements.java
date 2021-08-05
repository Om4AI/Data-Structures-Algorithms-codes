import java.lang.Math;
import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int dist[] = new int[arr.length];
        // Distances from each element
        for (int i=0; i<arr.length; i++){
            dist[i] = Math.abs(x-arr[i]);
        }
        // Sorting the arrays
        for (int i=0; i<dist.length-1; i++){
            for (int j=i+1; j<dist.length; j++){
                if (dist[i]>dist[j]){
                    int t,t1;
                    t = dist[i];
                    dist[i] = dist[j];
                    dist[j] = t;
                    t1 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t1;

                }
                else if (dist[i]==dist[j]){
                    if (arr[i]>arr[j]){
                        int t;
                        t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                    }
                }
            }
        }
        // Sorting done
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<k; i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list;
    }
}
