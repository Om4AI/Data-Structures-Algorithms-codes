class Solution {
    public int[] getSumAbsoluteDifferences(int[] arr) {
        int n = arr.length;
        int diff[] = new int[n-1];
        int left[] = new int[n];
        int right[] = new int[n];
        int res[] = new int[n];
        
        // Fill differences array
        for (int i=n-1; i>0; i--){
            diff[i-1] = arr[i]-arr[i-1];
        }

        // Fill right array
        for (int i=0; i<n-1; i++){
            right[i] = (n-i-1)*diff[i];
        }
        right[n-1] = 0;

        // Fill left array
        for (int i=n-1; i>0; i--){
            left[i] = i*diff[i-1];
        }
        left[0] = 0;

        // Modify the right and left arrays to get the running sums for each number
        int temp = 0;
        for (int i=n-1; i>=0; i--){
            temp+=right[i];
            right[i] = temp;
        }
        temp = 0;
        for (int i=0; i<n; i++){
            temp += left[i];
            left[i] = temp;
        }

        // Fill result
        for (int i=0; i<n; i++){
            res[i] = left[i] + right[i];
        }
        return res;
    }
}