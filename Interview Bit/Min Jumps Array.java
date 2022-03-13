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
