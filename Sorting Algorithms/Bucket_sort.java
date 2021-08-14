// Code by @Om
import java.util.*;
public class Bucket_sort_gen {

    @SuppressWarnings("unchecked")
    static void bucket_sort(int[] arr, int n, int max){
        List<Integer> buckets[] = new List[max+1];
        for (int i=0; i<n; i++){
            int el = arr[i];
            if (buckets[el]==null){
                buckets[el] = new ArrayList<Integer>();
            }
            buckets[el].add(el);
        }
        List<Integer> sorted = new ArrayList();
        for (int i=0; i<max+1; i++){
            if (buckets[i]!=null){
                sorted.addAll(buckets[i]);
            }
        }
        // System.out.println(sorted);
        for (int i=0; i<n; i++){
            arr[i] = sorted.get(i);
        }
    }

    static int get_max(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        for (int i:arr){
            list.add(i);
        }
        return Collections.max(list);
    }
    public static void main(String[] args) {
        int arr[] = {23,23,2,2,1,56,90,0};
        int m = get_max(arr);
        bucket_sort(arr, arr.length, m);
        System.out.println("\n\nSorted Array: ");
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}
