import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] arr) {
        // Min len str
        int min_len = Integer.MAX_VALUE;
        String min_s = arr[0];
        int n = arr.length;
        for (int i=0; i<n; i++){
            if (arr[i].length()<min_len){
                min_len = arr[i].length();
                min_s = arr[i];
            }
        }
        StringBuffer sb = new StringBuffer(min_s);

        // Compare with every other string
        for (int i=0; i<n; i++){
            if (arr[i].equals(min_s)) continue;
            else if (sb.length()==0) break;
            else{
                int sb_length = sb.length();
                int m = Math.min(sb_length, arr[i].length());
                int j=0, k=0;
                while (j<m && k<m){
                    if (arr[i].charAt(j) != sb.charAt(k)) break;
                    else{
                        j++;
                        k++;
                    }
                }
                sb.delete(k, sb_length);
            }
        }
        return sb.length()>0 ? sb.toString():"";
    }
}