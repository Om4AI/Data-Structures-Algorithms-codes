import java.util.*;

public class Solution {
    public int searchMatrix(int[][] arr, int target){
        // Start loop
        int n = arr.length, m = arr[0].length;
        for(int i=0; i<n; i++){
            int end = arr[i][m-1];
            if(target>=arr[i][0] && target<=end){
                if(binarySearch(arr,target,i,m)!=-1) return 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[][] arr, int target, int i, int m){
        int s = 0, e = m-1;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[i][mid]==target) return mid;
            else if(target>arr[i][mid]) s = mid+1;
            else e = mid-1;
        }
        return -1;
    }
}
