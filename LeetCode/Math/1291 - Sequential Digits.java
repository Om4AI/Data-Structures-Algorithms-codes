/*
 * In questions like this involving numbers, always try to
 * solve some of the constraints mathematically rather than using
 * programmatical verifications
 */
 
 import java.util.*;

 class Solution {
     public int create_sequential(int start, int k){
         StringBuffer sb = new StringBuffer();
         int p = start;
 
         while(k>0 && p<=9){
             sb.append(String.valueOf(p));
             p++;
             k--;
         }
         return Integer.parseInt(sb.toString());
     }
 
 
     public int find_beggining_index(int low){
         String s = String.valueOf(low);
         int first = create_sequential(Character.getNumericValue(s.charAt(0)), s.length());
         if (first>=low) return Character.getNumericValue(s.charAt(0));
         else return Character.getNumericValue(s.charAt(0))+1;
     }
 
 
     public List<Integer> sequentialDigits(int low, int high) {
         // Find the beginning index
         int start_index = find_beggining_index(low);
 
         // Initialize k value
         int k = String.valueOf(low).length();
 
         // Actual logic
         List<Integer> res = new ArrayList<>();
         int curr = 0, sp = start_index;

         while(curr<=high && k<=String.valueOf(high).length()){
             int max_k_nums = 9-k+1;
 
             while(max_k_nums>0 && sp<=(9-k)+1){
                 int num = create_sequential(sp, k);
                 if (num<=high){
                     res.add(num);
                     curr = num;
                 }
                 else return res;
                 
                 max_k_nums--;
                 sp++;
             }
             sp = 1;
             k++;
         }
         return res;
     }
 }