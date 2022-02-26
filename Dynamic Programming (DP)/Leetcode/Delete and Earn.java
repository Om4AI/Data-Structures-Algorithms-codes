class Solution {
    public int deleteAndEarn(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Remove duplicates & count occurences
        for(int i: nums){
            set.add(i);
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> l = new ArrayList<>(set);

        // Create unique elements sorted list
        Collections.sort(l);
        int arr[] = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            arr[i] = l.get(i);
        }
        // Matrix for memoization
        int t[][] = new int[arr.length+1][arr.length+1];
        for(int i=0; i<arr.length+1; i++) Arrays.fill(t[i], -1);
        
        // Function call
        return solve(arr,0,t,arr.length,map);
    }

    public static int solve(int[] arr, int sin, int[][] t, int n, HashMap<Integer, Integer> map){
        // Base Condition
        if(n==1) return arr[sin]*map.get(arr[sin]);
        if(n==2){
            if(arr[sin+1]-arr[sin]!=1) return arr[sin]*map.get(arr[sin]) + arr[sin+1]*map.get(arr[sin+1]);
            else return Math.max(arr[sin]*map.get(arr[sin]), arr[sin+1]*map.get(arr[sin+1]));
        }

        // Memoization check
        if(t[sin][n]!=-1) return t[sin][n];

        // Actual conditions
        int el = arr[sin], include=0;

        // Include the element
        if(arr[sin+1]==el+1){
            include = include + el*map.get(el) + solve(arr,sin+2,t,n-2,map);
        }else{
            include = include + el*map.get(el) + solve(arr,sin+1,t,n-1,map);
        }

        // Exclude element
        int exclude = solve(arr,sin+1,t,n-1,map);
        return t[sin][n] = Math.max(include, exclude);
    }
}