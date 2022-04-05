// 2-Pointer Approach
class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i=0, j = n-1;

        int max = 0;
        while(i<j){
            max = Math.max(max, (Math.min(arr[i], arr[j])*(j-i)));
            if(arr[i]<arr[j]) i++;
            else if(arr[i]>arr[j]) j--;
            else{
                i++;
                j--;
            }
        }
        return max;
    }
}
