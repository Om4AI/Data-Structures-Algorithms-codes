public class Solution {
    public int solve(int[] arr, int k){
        int i = 0, j= 0;
        
        while(j<arr.length){
            if(arr[j]==0) k--;
            if(k<0){
                if(arr[i]==0) k++;
                i++;
            }
            j++;
        }
        return j-i;
    }
}
