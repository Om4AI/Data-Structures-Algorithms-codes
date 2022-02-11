class Solution {
    public boolean validPalindrome(String s) {
        int a = 0, b = s.length()-1;
        while(a<=b){
            if(s.charAt(a)!=s.charAt(b)){
                // If character is not equal, then check with 2 possible removal strings
                if(palin_post_removal(s.substring(a+1, b+1)) || palin_post_removal(s.substring(a, b))) return true;
                // String is not a palindrome even after removal of 1 character
                else return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public boolean palin_post_removal(String s){
        // Check is string is palindrome post character removal
        int i = 0, j= s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}