// Recursion
import java.util.*;
class Solution {
    public static String s;
    public static int n;
    public List<List<String>> partition(String s1){
        s = s1;
        n = s.length();

        return all_possible_partitions(0);
    }

    public static List<List<String>> all_possible_partitions(int ind){
        List<List<String>> res = new ArrayList<>();

        // Base Case
        if (ind==n) return res;

        // Actual logic
        for(int i=ind; i<n; i++){
            if (isPalindrome(s.substring(ind, i+1))){
                String curr = s.substring(ind, i+1);
                List<List<String>> right = all_possible_partitions(i+1);

                // Add curr to every list
                for (int j=0; j<right.size(); j++){
                    List<String> temp = right.get(j);
                    temp.add(0, curr);
                    right.set(j, temp);
                }

                // If right is the last element (Blank list)
                if (right.size()==0){
                    List<String> inside = new ArrayList<>();
                    inside.add(curr);
                    right.add(inside);
                }


                res.addAll(right);
            }
        }
        return res;
    }

    // Helper Function
    public static boolean isPalindrome(String s){
        int l = 0, r=s.length()-1;
        while(l<r){
            if (s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}