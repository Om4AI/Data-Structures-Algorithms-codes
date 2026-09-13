import java.util.*;

public class Solution {
    public int mice(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int res = Integer.MIN_VALUE;
        for(int i=0; i<arr1.length; i++){
            res = Math.max(res, (Math.abs(arr1[i]-arr2[i])));
        }
        return res;
    }
}
