class Solution {
    public int searchInsert(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        
        if (target>arr[end]) return end+1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if (arr[mid]==target) return mid;
            else if (target<arr[mid]) end = mid-1;
            else start= mid+1;
        }
        return start;
    }
}
