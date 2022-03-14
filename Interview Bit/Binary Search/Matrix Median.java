public class Solution {
    public int findMedian(int matrix[][]){
        int n = matrix.length, m = matrix[0].length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        // Find the min & max range
        for(int i=0; i<n; i++) min = Math.min(min, matrix[i][0]);
        for(int i=0; i<n; i++) max = Math.max(max, matrix[i][m-1]);

        // Apply 1st Binary Search
        int s = min, e = max;
        while(s<=e){
            int mid = s+(e-s)/2;
            int els = findEls(matrix,mid,n), req_els = (n*m)/2, final_els = 0;
            if(checkElPresent(matrix,mid)){
                final_els = els-1;
                if(final_els==req_els) return mid;
            }else final_els = els;

            if(final_els > req_els) e = mid-1;
            else s = mid+1;
        }
        return s;
    }

    public static boolean checkElPresent(int[][] matrix, int target){
        int n1 = matrix.length;
        for(int i=0; i<n1; i++){
            int arr[] = matrix[i];
            int n = arr.length;
            int s =0, e = n-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid]==target) return true;
                else if(target>arr[mid]) s = mid+1;
                else e = mid-1;
            }
        }
        return false;
    }

    public static int findEls(int[][] matrix, int el, int n){
        int els = 0;
        // Apply Binary search for every row in the matrix
        for(int i=0; i<n; i++){
            els+=binarySearch(matrix[i],el);
        }
        return els;
    }

    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int s = 0, e = n-1;
        // Base condition
        if(target>=arr[n-1]) return n;

        // BS Loop
        while(s<=e){
            int mid = s+(e-s)/2;

            // Middle element == Target
            if(arr[mid]==target){
                if(arr[mid+1]!=target) return mid+1;
                else{
                    s = mid+1;
                    continue;
                }
            }else if(arr[mid]>target){
                if(mid==0) return 0;
                else if(arr[mid-1]<=target) return mid;
                else{
                    e = mid-1;
                    continue;
                }
            }else s = mid+1;
        }
        return 0;
    }
}