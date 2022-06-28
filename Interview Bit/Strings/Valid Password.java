public class Solution {
    public int solve(String s){
        int n = s.length();
        if(n<8 || n>15) return 0;
        int low = 0, up = 0, special = 0, num = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num++;
            else if(Character.isLowerCase(c)) low++;
            else if (Character.isUpperCase(c)) up++;
            else special++;
        }
        
        if(num>=1 && up>=1 && low>=1 && special>=1) return 1;
        else return 0;
    }
}
