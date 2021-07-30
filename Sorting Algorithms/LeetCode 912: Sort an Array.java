
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
