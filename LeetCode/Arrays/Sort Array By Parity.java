// Inplace swapping - No extra space used

class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int p = 0, n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]%2==0){
                int t = arr[p];
                arr[p] = arr[i];
                arr[i] = t;
                p++;
            }
        }
        return arr;
    }
}
