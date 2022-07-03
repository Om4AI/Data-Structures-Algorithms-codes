import java.util.*;
class Solution {
    public static HashMap<String,Integer> map;
    public int wiggleMaxLength(int[] nums){
        // Initialize new Hashmap 
        map = new HashMap<>();

        // Base case
        if(nums.length==1) return 1;

        // Find the array of differences
        int arr[] = new int[nums.length-1];
        int p =0;
        for(int i=1; i<nums.length; i++){
            arr[p] = nums[i]-nums[i-1];
            p++;
        }
        return 1+getWiggle(arr,arr.length,'s');
    }

    public static int getWiggle(int[] arr, int n, char f){
        
        // Generate key
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(n-1));
        sb.append(" ");
        sb.append(f);
        String k = sb.toString();
        
        // Base case
        if(n==0) return 0;
        else if(n==1){
            if((arr[n-1]<0 && f!='n')||(arr[n-1]>0 && f!='p')){
                map.put(k,1);
                return map.get(k);
            }
            else{
                map.put(k,0);
                return map.get(k);
            }
        }
        
        // Memoization check
        if(map.containsKey(k)) return map.get(k);

        // Normal cases
        // Negative element
        if(arr[n-1]<0 && f!='n'){
            // Include or exclude
            int res = Math.max(1+getWiggle(arr,n-1,'n'), getWiggle(arr,n-1,f));
            map.put(k,res);
        }else if(arr[n-1]>0 && f!='p'){
            // Include or exclude
            int res = Math.max(1+getWiggle(arr,n-1,'p'), getWiggle(arr,n-1,f));
            map.put(k,res);
        }else{
            // exclude
            int res = getWiggle(arr,n-1,f);
            map.put(k,res);
        }
        return map.get(k);
    }
}