// Merge-Sort Java Code by @Om

import java.util.*;


public class Merge_Sort {

    static void merge(int[] arr, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;
        // Assumption: The two arrays: arr[l...m] & arr[m+1...r] are sorted
        // Split the array arr[] into the left ad the right subarrays

        int L[] = new int[n1]; // Array for the left subarray
        int R[] = new int[n2];  //Array for the right subarray

        // Create arrays
        for (int i=0; i< n1; ++i){L[i] = arr[l+i];}
        for (int j=0; j< n2; ++j){R[j] = arr[m+1+j];}

        // Actual process of merging
        // Indexes for the left & right subarray
        int i = 0, j = 0;
        int k = l;

        while (i<n1 && j<n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] or R[]
        // (Incase some array has length greater than the other)
        while (i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void msort(int[] arr, int l, int r){
        if (l<r){
            // Get the midpoint
            int m = l + (r-l)/2;

            msort(arr, l, m);    //Sort the left subarray
            msort(arr, m+1, r);  //Sort the right subarray

            // Merge the sorted arrays
            merge(arr, l, m, r);
        }
        
    }
    
    public static void main(String[] args) {
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        msort(arr, 0, arr.length-1);
        System.out.println("\n\nSorted Array: ");
        for (int i=0; i<arr.length; i++){System.out.print(arr[i]+" ");}
        System.out.println("\n\n");
    }    
}
