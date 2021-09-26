class Solution {
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        int mid  = (start+end)/2;
        while (start<=end){
            mid  = (start+end)/2;
            if (arr[mid]==target) return mid;
            else if (target>arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
