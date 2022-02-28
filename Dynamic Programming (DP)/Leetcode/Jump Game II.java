// Top-Down Approach
class Solution {
    public int jump(int[] arr){
        int t[] = new int[arr.length+1];
        for(int i=0; i<arr.length+1; i++) t[i] = arr.length+1;

        return jumpii(arr,0,t);
    }

    public static int jumpii(int[] arr, int index, int[] t){
        int vals = arr[index];
        
        // Base condition
        if(index == arr.length-1) return 0;
        if(index+vals >=arr.length-1) return 1;
        if(vals==0) return arr.length+1;
        
        // Memoization check
        if(t[index]!=arr.length+1) return t[index];

        // Main logic
        int min_jumps = Integer.MAX_VALUE;
        for(int i=1; i<=vals; i++){
            int jumps = 1+jumpii(arr, index+i, t);
            min_jumps = Math.min(min_jumps, jumps);
        }
        return t[index] = min_jumps;
    }
}


// Bottom-Up Approach
public class Solution {
    public int jump(int[] arr){
        int t[] = new int[arr.length+1];
        for(int i=0; i<arr.length+1; i++) t[i] = arr.length+1;

        return jumpii(arr,t);
    }

    public static int jumpii(int[] arr, int[] t){
        
        for(int i=arr.length-1; i>=0; i--){
            // Base condition
            if(i==arr.length-1) t[i] = 0;
            else{
                int vals = arr[i];
                if(i+vals>=arr.length-1){
                    t[i] = 1;
                    continue;
                }
                int min = arr.length+5;
                for(int j=1; j<=vals; j++){
                    int jmps = 1 + t[i+j];
                    min = Math.min(jmps, min);
                }
                t[i] = min;
            }
        }
        return t[0];
    }
}
