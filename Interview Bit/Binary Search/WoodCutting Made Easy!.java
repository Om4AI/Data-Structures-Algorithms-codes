public class Solution {
    public int solve(int[] arr, int wood) {
        // Sort & find the sum array
        int n = arr.length, s = 0;
        int sums[] = new int[n];
        Arrays.sort(arr);
        for(int i=n-1; i>=0; i--){
            s+=arr[i];
            sums[i] = s;
        }

        int len = arr[n-1];
        // Start loop from maximum element
        while(true){
            // log(n) search
            int elindex = findElement(arr,len);

            // Calculate wood cut
            if(sums[elindex]-((n-elindex)*len)>=wood) return len;
            len--;
        }
    }

    public static int findElement(int[] arr, int target){
        int s = 0, e = arr.length-1;
        // Case 1 - Target Element found
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid]==target) return mid;
            else if(target>arr[mid]) s=mid+1;
            else e = mid-1;
        }

        // Case 2 - Target element not found
        s = 0;
        e = arr.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid]>target && target>arr[mid-1]) return mid;
            else if(arr[mid]<target) s = mid+1;
            else if(arr[mid-1]>target) e = mid-1;
        }
        return -1;
    }
}
