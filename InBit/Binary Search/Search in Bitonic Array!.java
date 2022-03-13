public class Solution {
    public int solve(int[] arr, int target){
        int n = arr.length, index = 0;
        int start = 0, end = n-1;

        if(n==0) return -1;

        // Find peak or index
        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid==0 || mid==n-1) {
                index = mid;
                break;
            }
            else if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                index = mid;
                break;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]) start = mid+1;
            else end = mid-1;
        }
        
        if(arr[index]==target) return index;

        int res = binarySearch(arr,0,index-1,target,true);
        if(res==-1) res = binarySearch(arr,index+1,n-1,target,false);
        return res;
    }

    public static int binarySearch(int[] arr, int start, int end, int target, boolean isIncreasing){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target) return mid;
            else if (target > arr[mid]){
                if(isIncreasing) start = mid+1;
                else end = mid-1;
            }else if(target<arr[mid]){
                if(isIncreasing) end = mid-1;
                else start = mid+1; 
            }
        }
        return -1;
    }
}
