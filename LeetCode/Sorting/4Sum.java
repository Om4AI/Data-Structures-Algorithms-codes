import java.util.*;

// Code by @Om Mule


class Solution {
    public List<List<Integer>> fourSum(int[] n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // First element
        for (int i=0; i<n.length-3; i++){
            // Second element
            for (int j=i+1; j<n.length-2; j++){
                // Third element
                for (int k=j+1; k<n.length-1; k++){
                    // Fourth element
                    for (int l=k+1; l<n.length; l++){
                        if (n[i]+n[j]+n[k]+n[l] == target){
                            List<Integer> temp = new ArrayList<Integer>();
                            temp.add(n[i]);
                            temp.add(n[j]);
                            temp.add(n[k]);
                            temp.add(n[l]);
                            res.add(temp);
                        }
                    }
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i=0; i<res.size(); i++){
            Collections.sort(res.get(i));
        }
        for (List<Integer> l:res){set.add(l);}
        
        List<List<Integer>> res1 = new ArrayList<>();
        for (List<Integer> l: set){
            res1.add(l);
        }
        return res1;
    }
}
