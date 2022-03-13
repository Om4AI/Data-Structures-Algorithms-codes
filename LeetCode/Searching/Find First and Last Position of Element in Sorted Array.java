public class Solution {
    public int[] searchRange(final int[] arr, int target){
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        int n = arr.length;

        // Find the starting index
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]==target){
                if(mid==0){
                    res[0] = 0;
                    break;
                }
                else if(arr[mid-1]!=target){
                    res[0] = mid;
                    break;
                }else{
                    e = mid-1;
                    continue;
                }
            }else if(target>arr[mid]) s = mid+1;
            else e = mid-1;
        }

        // Find the ending index
        s = 0;
        e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]==target){
                if(mid == n-1){
                    res[1] = mid;
                    break;
                }
                else if(arr[mid+1]!=target){
                    res[1] = mid;
                    break;
                }else s = mid+1;
            }else if(target>arr[mid]) s = mid+1;
            else e = mid-1;
        }
        return res;
    }
}
