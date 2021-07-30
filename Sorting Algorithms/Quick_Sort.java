// Quick Sort (In Java): Code by @Om

import java.util.*;

// Last element as Pivot (Quick Sort)
public class Quick_Sort {
    
    // Swapping function
    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    static int partition(int arr[], int low, int high){
        int pivot = arr[high]; //Last element as pivot

        // Index of smaller element to get position of pivot
        int i = low-1;

        // Loop for the main logic
        for (int j=low; j< high; j++){

            // If current element is smaller than the pivot
            if (arr[j]< pivot){
                i++;
                // Swap the elements
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1; //return the correct index of the element
    }


    static void quickSort(int[] arr, int low, int high){
        if (low < high){
            // pi (partioning index); element arr[pi] is in right position
            int pi = partition(arr, low, high);

            // Sort the left & right subarrays
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }

    }

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        // Quick Sort
        quickSort(arr, 0, n-1);
        System.out.println("\nSorted Array: ");
        for (int i=0; i<arr.length; i++){System.out.print(arr[i]+" ");}
    }
}
