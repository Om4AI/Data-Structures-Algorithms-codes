// Code by Om
class Solution {
    static HashMap<String, Boolean> map;
    
    public boolean splitArraySameAverage(int[] arr){
        map = new HashMap<>();
        int n = arr.length, total = 0;
        for(int i: arr) total+=i;
        
        // For every number of elements -> Find the sum that must be achieved
        for(int i=1; i<n; i++){
            int sum = (i*total)/n;
            if((i*total)%n!=0) continue;

            if(canSplit(i,arr,sum,n)) return true;
        }
        return false;
    }

    public static boolean canSplit(int len, int[] arr, float sum, int n){

        // Create the key for the map
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(len));
        sb.append(" ");
        sb.append(String.valueOf(sum));
        sb.append(" ");
        sb.append(String.valueOf(n));
        String key = sb.toString();

        // Base cases
        if(n==0){
            if(sum==0 && len==0) return true;
            else return false;
        }else if(len==0){
            if(sum==0) return true;
            else return false;
        }
        
        // Memoization check
        if(map.containsKey(key)) return map.get(key);

        // Include the element in the sum or exclude the element 
        boolean val = (canSplit(len-1,arr,sum-arr[n-1],n-1)) || (canSplit(len,arr,sum,n-1));
        map.put(key, val);
        return map.get(key);
    }
}

