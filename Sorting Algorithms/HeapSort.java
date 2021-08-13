// Code by @Om

public class HeapSort {

    // Heapsort Function 
    static void heapsort(int[] arr){
        // Length of array
        int n = arr.length;

        // Build a heap (use heapify)
        for (int i=n/2-1; i>=0; i--){
            // Heapify a subtree where node is at (i)th index
            heapify(arr, n, i);
        }

        // Remove the largest/smallest element from top of heap
        for (int i=n-1; i>0; i--){
            // arr[0]: Top of heap (Move to the end)
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;

            // Heapify the reduced elements
            heapify(arr, i, 0);
        }
    }

    // Heapify Function
    static void heapify(int[] arr, int n, int i){
        // Largest as the root node
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l<n && arr[l] > arr[largest])
            largest = l;
        
        if (r<n && arr[r] > arr[largest])
            largest = r;
        
        // Till this we changed among the variable largest
        // Change in array (Swap the greater child to the root position)
        if ( largest != i){
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;

            // Recursive heapify subtree
            heapify(arr, n, largest);
        }
    }

    // Main Function
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
        heapsort(arr);

        System.out.println("\nSorted Array: ");
        for (int i: arr) System.out.print(i+" ");
    }
}
