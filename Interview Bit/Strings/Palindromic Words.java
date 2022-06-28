public class Solution {
    public int solve(String s){
        String arr[] = s.split(" ");
        int res = 0;
        for(String i: arr) if(isPalindrome(i)) res++;
        return res;
    }
    
    public static boolean isPalindrome(String s){
        int i=0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
