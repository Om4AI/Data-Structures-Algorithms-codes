class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, f = 1, index = 0;
        if(arr.length<3) return false;

        // Equal case
        for(int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1]) return false;
        }

        // Find global or local maxima
        for(int i=1; i<n-1; i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) index = i;
        }

        if(index==0) return false;
        for(int i=0; i<index; i++) if(arr[i]>arr[i+1]) return false;
        for(int i=index; i<n-1; i++) if(arr[i]<arr[i+1]) return false;

        return true;
    }
}
