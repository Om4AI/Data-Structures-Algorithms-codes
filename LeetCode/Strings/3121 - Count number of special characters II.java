// Approach
//      1. Traverse through the array & populate if lower & upper case characters are present
//      2. For every lowercase character - Check if upper case already occurred - (Not special)
//      3. For every uppercase character - Check if char didn't appear earlier & lowercase for same has occurred earlier - (Special currently)
//      4. Store the special & not special status in the 3rd array (res)
//      5. Count the occurrences of special characters after all character have been traversed

class Solution {
    public int numberOfSpecialChars(String word){
        int[] lower = new int[26];
        int[] upper = new int[26];
        int[] res = new int[27];

        // Finding which characters are present
        for (char c:word.toCharArray()){
            if (Character.isLowerCase(c)){
                int index = c-'a';
                // Check if upper case already present
                if (upper[index]==1) res[index] = 0;
                lower[index] = 1;
            }else if (Character.isUpperCase(c)){
                int index = c-'A';
                if (upper[index]!=1 && lower[index]==1) res[index] = 1;
                upper[index] = 1;
            }
        }

        int count = 0;
        for (int i=0; i<26; i++){
            if (res[i]==1) count++;
        }
        return count;
    }
}