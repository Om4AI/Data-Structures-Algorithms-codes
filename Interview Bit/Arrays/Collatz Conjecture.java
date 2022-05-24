import java.util.*;

public class Solution {
    public long solve(int a, int b) {
        long a1 = Long.valueOf(a);
        while(b-->1){
            a1 = (a1%2==0)?(a1/2):(3*a1+1);
        }
        return a1;
    }
}

