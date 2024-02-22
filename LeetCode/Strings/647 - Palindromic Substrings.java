package Strings;
/*
 *
 * This solution doesn't use DP and uses a very optimized method instead
 * There are 2 cases: 
 *      1. Odd indices - Start with the left (l) and right (r) pointers from a single element
 *                       which is the middle element and then the l & r pointers move in left
 *                       and right direction until they either go out of bounds or elements on
 *                       those indices are not equal
 *      2. Even indices - Start with left and right pointers from adjacent elements. These move
 *                        in the same fashion as above
 * 
 */
import java.util.*;
class Solution {
    public static String s;
    public int countSubstrings(String s1) {
        s = s1;
        int res = 0;
        // Odd indices (Initialize l & r at the same element)
        for (int i=0; i<s.length(); i++){
            res+= get_palindromes(i,i);
        }
        // Even indices (Initialize l & r at adjacent indices)
        for(int i=0; i<s.length()-1; i++){
            res += get_palindromes(i, i+1);
        }
        return res;
    }

    public static int get_palindromes (int l, int r){
        int res = 0;
        while(l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
            res++;
            l--;
            r++;
        }
        return res;
    }
}