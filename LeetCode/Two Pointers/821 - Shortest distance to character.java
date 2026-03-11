import java.util.*;

class Solution {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> pos = new ArrayList<>();
        int n = s.length();
        // Fetch the character positions
        for (int i=0; i<n; i++){
            if (s.charAt(i) == c){
                pos.add(i);
            }
        }

        // Pass
        int res[] = new int[n];
        int j=0;
        for (int i=0; i<n; i++){
            if (j<pos.size()-1){
                if (Math.abs(i-pos.get(j+1)) <= Math.abs(i-pos.get(j))){
                    res[i] = Math.abs(i-pos.get(j+1));
                    j++;
                }else{
                    res[i] = Math.abs(i-pos.get(j));
                }
            }else{
                res[i] = Math.abs(i-pos.get(j));
            }
        }
        return res;
    }
}