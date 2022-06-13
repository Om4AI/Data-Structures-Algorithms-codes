class Solution {
    public int maximumProduct(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int neg = arr[0]*arr[1]*arr[n-1], pos = arr[n-1]*arr[n-2]*arr[n-3];
        
        return (pos>neg)?pos:neg;
    }
}
