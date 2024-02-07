/*
 * Custom array sorting can be done in 2 ways: Custom comparator  ||  Lambda expression
 * 
 * Example:   Arrays.sort(arr, (a,b) -> b.occurence-a.occurence);
 *          The lambda expression beginning with (a,b) -> says that a & b are 2 consecutive
 *          elements in the array (arr: another argument). They must be sorted by checking the
 *          value of (b.occurence-a.occurence)
 * 
 * Case for swapping: 
 *      Positive - Swap   ||   Else do nothing
 * 
 * Types of sorting: 
 *      1. Ascending -- (a-b)
 *      2. Descending -- (b-a)
 */

import java.util.*;
class CharFreq{
    char character; 
    int occurence;

    CharFreq(char c, int occ){
        character = c;
        occurence = occ;
    }
}

class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        // Get the characters and frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // Create an array of CharFreq objects
        CharFreq arr[] = new CharFreq[map.size()];
        int p = 0;
        for (char key: map.keySet()){
            arr[p] = new CharFreq(key, map.get(key));
            p++;
        }

        // Custom sorting the CharFreq array
        Arrays.sort(arr, (a,b)-> b.occurence-a.occurence);

        // Create resultant string
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<arr.length; i++){
            sb.append(String.valueOf(arr[i].character).repeat(arr[i].occurence));
        }
        return sb.toString();
    }
}
