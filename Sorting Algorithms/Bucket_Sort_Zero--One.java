// Bucket Sort for numbers from 0 - 1

import java.util.*;

public class Bucket_Sort {

    static void bucket_sort(float[] arr, int n){
        // We have to make the changes to the same array

        @SuppressWarnings("unchecked")
        // 1. Create n buckets
        ArrayList<Float> buckets[] = new ArrayList[n];
        for (int i=0; i<n; i++){
            buckets[i] = new ArrayList<>();
        }

        // 2. Put the elements into the buckets
        for (int i=0; i<n; i++){
            float index = n*arr[i];
            (buckets[(int)index]).add(arr[i]);
        }

        // 3. Sort the Lists 
        for (int i=0; i<n; i++){
            Collections.sort(buckets[i]);
        }

        // 4. Add all the elements to arr
        int c = 0;
        for (int i=0; i<n ; i++){  // Traverse buckets
            for (int j=0 ;j<buckets[i].size(); j++){
                arr[c] = buckets[i].get(j);
                c+=1;
            }
        }
    }

    public static void main(String[] args) {
        float arr[] = { (float)1.234, (float)0.565,
            (float)0.656, (float)0.1234,
            (float)0.665, (float)0.3434 };
        int n = arr.length;  // Length of the array

        bucket_sort(arr, n);
        System.out.println("Sorted Array: \n");
        for (float el:arr){
            System.out.print(el+" ");
        }
        System.out.println();
    }
}
