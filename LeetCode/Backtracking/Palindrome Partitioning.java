import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
      
//       Solution list
        List<List<String>> res = new ArrayList<>();
        backtrack(res,s,new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<String>> res, String s, List<String> ref_list){
      
        // Base cases - Eventually when the string keeps on getting divided
        if(s.isEmpty()) {
            res.add(ref_list);
        }

        // Try all the partitions from 1 - (n-1)
        for(int i=1; i<=s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
          
//           Check if left substring is a palindrome
            if(ispalindrome(left)){
//               Create a copy of the OG list
                List<String> list = new ArrayList<>(ref_list);
                list.add(left);
              
//               Recursive call
                backtrack(res,right,list);
            }
        }

    }
  
//   Function to check palindrome
    public boolean ispalindrome(String s){
        int i=0,j = s.length()-1, f=1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                f=0;
                break;
            }
            i++;
            j--;
        }
        return f==1;
    }
}
