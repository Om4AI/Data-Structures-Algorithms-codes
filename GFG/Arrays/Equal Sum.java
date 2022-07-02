// Prefix sum
class Solution {
    String equilibrium(int arr[], int n){
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = arr[0];
        for(int i=1; i<n; i++) left[i] = arr[i]+left[i-1];
        right[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--) right[i] = right[i+1]+arr[i];
        
        // Check equal sum
        for(int i=0; i<n; i++){
            if(i==0){
                if(right[i+1]==0) return "YES";
            }else if(i==n-1){
                if(left[i-1]==0) return "YES";
            }else{
                if(left[i-1]==right[i+1]) return "YES";
            }
        }
        
        return "NO";
    }
}
