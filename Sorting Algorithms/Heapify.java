import java.util.*;
public class Heapify {

    static void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if (l<n && arr[largest]<arr[l]){
            largest = l;
        }
        if (r<n && arr[largest]<arr[r]){
            largest = r;
        }
        // Swap
        if (largest != i){
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;

            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 10, 3, 5, 1};
        int n = arr.length;
        // Create a heap
        for (int i=n/2 -1; i>=0; i--){
            heapify(arr, n, i);
        }
        // Print the heap
        System.out.println("\nHeap: ");
        for (int i: arr) System.out.print(i+" ");
    }
}
