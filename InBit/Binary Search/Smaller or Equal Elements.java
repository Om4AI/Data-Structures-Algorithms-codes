import java.util.*;
public class Solution {
    public int solve(int[] arr, int target){
        int n = arr.length, s = 0;
        int e = n-1, found_last = 0;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid==n-1){
                if(arr[mid]<=target) return mid+1;
                else return mid;
            }
            if(arr[mid]==target){
                if(arr[mid+1]!=target){
                    found_last = 1;
                    return mid+1;
                }else{
                    s = mid+1;
                    continue;
                }
            }else if(target>arr[mid]) s = mid+1;
            else e = mid-1;
        }
        
        if(found_last==0){
            s = 0;
            e = n-1;
            while(s<=e){
                int mid = s + (e-s)/2;

                if(mid==n-1){
                    if(arr[mid]<target) return mid+1;
                    else return mid;
                }
                else if(arr[mid]>target && arr[mid-1]<target) return mid;
                else if(arr[mid]>target && arr[mid-1]>target){
                    e = mid-1;
                }else s = mid+1;
            }
        }
        return -1;
    }
}
