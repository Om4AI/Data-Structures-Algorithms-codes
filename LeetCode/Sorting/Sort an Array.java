// Quick Sort (Accepted)

class Solution {
    
    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i= low-1;
        for (int j=low; j<high; j++){
            if (arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    
    static void quickSort(int[] arr, int low, int high){
        if (low<high){
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        return nums;
    }
}


// ------------------------------------------------------------


// Merge Sort (Accepted) - 11ms
class Solution {
    
    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
//         Create Arrays
        for (int i=0; i<n1; ++i){L[i] = arr[l+i];}
        for (int j=0; j<n2; ++j){R[j] = arr[m+1+j];}
        
        int i=0, j=0, k=l;
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
        
//         Remaining elements in subarrays
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
    
    static void msort(int[] arr, int l,int r){
        if (l<r){
            int m = l + (r-l)/2;
        
//         Divide & Sort subarrays
            msort(arr, l, m);
            msort(arr, m+1, r);
            
            merge(arr, l, m, r);
        }
    }
    
    
    
    
    public int[] sortArray(int[] arr) {
        msort(arr, 0, arr.length-1);
        return arr;
    }
}


// ----------------------------------------------------


// Arrays.sort(arr) (Accepted) - 5ms
class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
