import java.util.*;

// Solution 1 - My solution (60ms)
// Issues with this:
//  1. The substrings which we are creating are using a lot of extra time & memory for creation
//  2. I had used HashMap first, always use an Array for occurrence storing when the total keys are known
class Solution {
    static int k;
    public int longestSubstring(String s, int k) {
        this.k = k;
        return findLongestSubstring(s);
    }

    public int findLongestSubstring(String s){
        // Occurences of characters
        int[] freq = new int[26];
        int n = s.length();
        for (int i=0; i<n; i++){
            // s.charAt(i)-'a': This gets the index of the character
            freq[s.charAt(i)-'a']++;
        }

        // Find occurrences & split the string at the (first_occurrence < k)
        for (int i=0; i<n; i++){
            // Occurrence of character < k
            if (freq[s.charAt(i)-'a']<k){
                // Split at that character
                return Math.max(findLongestSubstring(s.substring(0,i)), findLongestSubstring(s.substring(i+1,n)));
            }
        }
        return n;
    }
}

// Solution 2 - Optimized solution with start & end pointers (Two pointers approach) (57ms)
// Improvements:
//  1. The complete string checks are added (either complete discarded or complete string is longestSubstring)
//  2. The approach to parse the string and discard which isn't used from before
//  3. Avoids the creation of multiple recursion trees & processes all invalid characters in single loop
class Solution {
    static int k;
    public int longestSubstring(String s, int k) {
        this.k = k;
        return findLongestSubstring(s, 0, s.length());
    }

    public int findLongestSubstring(String s, int start, int end){
        if (end - start < k) return 0;
        // Occurences of characters
        int[] freq = new int[26];
        for (int i=start; i<end; i++){
            // s.charAt(i)-'a': This gets the index of the character
            freq[s.charAt(i)-'a']++;
        }

        // Check if complete string is valid
        boolean completeValid = true;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0 && freq[i] < k) {
				completeValid = false;
				break;
			}
		}
		if (completeValid) {
			return end - start;
		}

        // There are some characters which don't satisfy the condition
        int maxLen = 0, left = start;
        // Find occurrences & split the string at the (first_occurrence < k)
        for (int right=start; right<end; right++){
            // Occurrence of character < k
            if (freq[s.charAt(right)-'a']<k){
                // Split at that character
                maxLen = Math.max(maxLen, findLongestSubstring(s,left,right));
                // Remove the earlier string from picture
                left = right+1;
            }
        }
        return Math.max(maxLen, findLongestSubstring(s,left,end));
    }
}