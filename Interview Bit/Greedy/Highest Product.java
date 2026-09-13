import java.util.*;
import java.lang.Math;


public class Solution {
    public int maxp3(int[] A){
        Arrays.sort(A);
        int n = A.length;
        int neg = A[0]*A[1]*A[n-1], pos = A[n-1]*A[n-2]*A[n-3];
        
        return (neg>pos)? neg:pos;
    }
}
