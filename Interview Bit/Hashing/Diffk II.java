import java.util.*;

public class Solution {
    public int diffPossible( int[] arr, int k){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            int el = arr[i];
            if(set.contains(el)) return 1;
            else{
                set.add(el-k);
                set.add(k+el);
            }
        }
        return 0;
    }
}
