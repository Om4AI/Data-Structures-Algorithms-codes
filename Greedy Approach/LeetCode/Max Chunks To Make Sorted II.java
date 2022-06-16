import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr){
        int n = arr.length;
        int lmax[] = new int[n+1], rmin[] = new int[n+1];
        lmax[0] = arr[0];
        rmin[n] = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        }

        for(int i=n-1; i>=0; i--){
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }

        // Count maximum chunks
        int c = 0;

        // There doesn't exist a minimum value to the right that needs to be on the left of the current element
        // The <= condition is for maximum chunks, because equal elements can also come after the current element
        for(int i=0; i<n; i++){
            if(lmax[i]<=rmin[i+1]) c++;
        }
        return c;
    }
}