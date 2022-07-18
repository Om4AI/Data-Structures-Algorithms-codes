import java.util.*;
public class Solution {
    public static ArrayList<Integer> res;
    public static ArrayList<Integer> subsetSum(int arr[]) {
        res = new ArrayList<>();
        getSubsets(arr, 0,0);
        Collections.sort(res);
        return res;
    }
    
    
    public static void getSubsets(int[] arr, int i, int sum){
        // Base case
        if(i==arr.length){
            res.add(sum);
            return;
        }
        
        // Accept current or reject
        getSubsets(arr,i+1,sum+arr[i]);
        getSubsets(arr,i+1,sum);
    }
}
