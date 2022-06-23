import java.util.*;

public class Solution {
    public int[] lszero(int[] arr){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(-1);
        map.put(0,zero);
        int n = arr.length, sum=0;

        // Find prefix-sum for the array
        int sums[] = new int[n];
        for(int i=0; i<n; i++){
            sum+=arr[i];
            sums[i] = sum;
        }

        // Fill the map
        List<Integer> keys = new ArrayList<>();
        keys.add(0);
        for(int i=0; i<n; i++){
            int curr = sums[i];
            if(!map.containsKey(curr)){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(curr,l);
                keys.add(curr);
            }else if(map.containsKey(curr)){
                List<Integer> l = map.get(curr);
                if(l.size()==2) l.set(1,i);
                else l.add(i);
                map.put(curr,l);
            }
        }

        // Find the maximum number of elements
        int max = 0, maxKey=-1;
        for(int k:keys){
            List<Integer> l = map.get(k);
            if(l.size()==2){
                int elements = (l.get(1)-l.get(0));
                if(elements>max){
                    max = elements;
                    maxKey = k;
                }
            }
        }

        if(max==0) return new int[0];
        else{
            int s = map.get(maxKey).get(0), e = map.get(maxKey).get(1);
            int t = e-s, p=0;
            int res[] = new int[t];
            for(int i=s+1; i<=e; i++){
                res[p] = arr[i];
                p++;
            }
            return res;
        }
    }
}
