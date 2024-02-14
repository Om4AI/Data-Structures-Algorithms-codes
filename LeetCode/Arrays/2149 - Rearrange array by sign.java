import java.util.*;

// More optimized solution
class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        int posp = 0, negp = 1;

        for(int i=0; i<n; i++){
            if (arr[i]>0){
                res[posp] = arr[i];
                posp+=2;
            }else{
                res[negp] = arr[i];
                negp+=2;
            }
        }
        return res;
    }
}



// More space and more time complexity
class Solution {
    public int[] rearrangeArray(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Fill the arraylists
        for (int i=0; i<arr.length; i++){
            if (arr[i]>0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }

        // Create resultant array
        int posp = 0, negp = 0;
        for (int i=0; i<arr.length; i++){
            if (i%2==0 && posp<pos.size()){
                arr[i] = pos.get(posp);
                posp++;
            }else{
                arr[i] = neg.get(negp);
                negp++;
            }
        }
        return arr;
    }
}

