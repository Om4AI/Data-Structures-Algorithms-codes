// -----------------------Interview Bit Format Solution-------------------------
import java.util.*;
public class Solution {
    public int perfectPeak(int[] arr){
        int n = arr.length, max = arr[0], min = arr[arr.length-1];
        int maxes[] = new int[n], mins[]= new int[n];

        // Fill up maxes
        for(int i=0; i<n; i++){
            maxes[i] = Math.max(max, arr[i]);
            max = maxes[i];
        }

        // Fill up mins
        for(int i=n-1; i>=0; i--){
            mins[i] = Math.min(min, arr[i]);
            min = mins[i];
        }

        // Find the peak element
        for(int i=1; i<n-1; i++) if((maxes[i-1]<arr[i] && mins[i+1]>arr[i])) return 1;
        return 0;
    }
}



// -----------------------Local Testing Solution-------------------------
public class Perfect_Peak_Of_Array {
    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 4};
        System.out.println(perfectPeak(arr)); 
    }

    public static int perfectPeak(int[] arr){
        int n = arr.length, max = arr[0], min = arr[arr.length-1];
        int maxes[] = new int[n], mins[]= new int[n];

        // Fill up maxes
        for(int i=0; i<n; i++){
            maxes[i] = Math.max(max, arr[i]);
            max = maxes[i];
        }

        // Fill up mins
        for(int i=n-1; i>=0; i--){
            mins[i] = Math.min(min, arr[i]);
            min = mins[i];
        }

        // Find the peak element
        for(int i=1; i<n-1; i++) if((maxes[i-1]<arr[i] && mins[i+1]>arr[i])) return 1;
        return 0;
    }
}
