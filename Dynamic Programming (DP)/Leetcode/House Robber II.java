class Solution {
    public int rob(int[] arr){
        int n = arr.length;
        HashMap<String, Integer> map = new HashMap<>();
        return house_rob(arr,0,map,n,0);
    }
    
    public static int house_rob(int[] arr, int sin, HashMap<String, Integer> map, int n, int start_include){
        // Base condition
        if(n==1){
            if(start_include==1) return 0;
            else return arr[sin];
        }
        
        if(n==2){
            if(start_include==1) return arr[sin];
            else return Math.max(arr[sin], arr[sin+1]);
        }
        
        // Check memoization
        StringBuffer sb = new StringBuffer(Integer.toString(sin));
        sb.append(" ");
        sb.append(Integer.toString(n));
        sb.append(" ");
        sb.append(Integer.toString(start_include));
        String temp = sb.toString();
        if(map.containsKey(temp)) return map.get(temp);
        
        //Actual logic
        int max = Integer.MIN_VALUE;

        // Maximum - Inclusion & Exclusion case
        if(sin==0){
            max = Math.max((arr[sin]+house_rob(arr,sin+2,map,n-2,1)),(house_rob(arr,sin+1,map,n-1,0)));
        }else{
            max = Math.max((arr[sin]+house_rob(arr,sin+2,map,n-2,start_include)),(house_rob(arr,sin+1,map,n-1,start_include)));
        }
        
        map.put(temp,max);
        return map.get(temp);
    }
}