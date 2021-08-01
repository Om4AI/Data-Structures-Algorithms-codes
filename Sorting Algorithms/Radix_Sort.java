import java.util.*;

public class Radix_Sort {

    // Get the maximum number for the no. of digits
    static int getmax(int[] arr, int n){
        int max = arr[0];
        for (int i=0; i<n; i++){
            if (arr[i]>max) max = arr[i];
        }
        return max;
    }

    // Counting Sort
    static void counting_sort(int[] arr, int n, int exp){

        int res[]=  new int[n];

        //Assume digits in number be 10
        int count[] = new int[10];

        // Store the count of occurences
        for (int i=0; i<n; i++){
            count[(arr[i]/exp) % 10]++;
        }

        // Get the new counts by adding the previous ones
        for (int i=1; i<10; i++){
            count[i] += count[i-1];
        }

        // Resultant Array
        for (int i= n-1; i>=0; i--){
            res[count[(arr[i]/exp) % 10]-1] = arr[i];
            count[(arr[i]/exp) % 10]--;
        }
        
        // Transfer the sorted array to the actual arr[]
        for (int i=0; i<n; i++){
            arr[i] = res[i];
        } 
    }


    static void radixsort(int[] arr, int n){
        // Get the number of digits
        int m = getmax(arr, n);

        // Perform counting sort on every digit
        for (int exp=1; m/exp > 0; exp*=10){
            // Exp is sort of like the 1s', 10s'... places
            counting_sort(arr, n, exp);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };

        radixsort(arr, arr.length);
        System.out.println("\nSorted Array: ");
        for (int i=0; i<arr.length; i++){System.out.print(arr[i]+" ");}
    }
}
