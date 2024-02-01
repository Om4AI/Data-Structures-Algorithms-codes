/*
 * A question could possibly be solved with DP only is the problem 
 * statement mentions to find something like least, most ways etc.
 * 
 * Approach to the question: If 2 strings need to make equal using 2 methods
 * and we have unlimited chances on a method, the only things we need to check
 * are - 
 * 1. If both strings have same letters
 * 2. If both strings have same set of occurence numbers
 */

import java.util.*;

class Solution {
    public HashSet<Character> get_characters(String word){
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<word.length(); i++){
            set.add(word.charAt(i));
        }
        return set;
    }

    public int[] get_occurences(String word){
        int arr[] = new int[26];
        for (int i=0; i<word.length(); i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        return arr;
    }


    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        // Edge case: Different lengths
        if (n1!=n2) return false;

        // Check 1 - Both strings have same alphabets
        HashSet<Character> s1 = get_characters(word1);
        HashSet<Character> s2 = get_characters(word2);

        if (!s1.equals(s2)) return false;

        // Check 2 - Both strings have same occurences
        int[] occ1 = get_occurences(word1);
        int[] occ2 = get_occurences(word2);
        
        for (int i=0; i<occ1.length; i++){
            if (occ1[i]!=occ2[i]) return false;
        }
        return true;
    }
}