import java.util.*;

public class Solution {
    public int solve(String s) {
        int vowel = 0, consonant = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                vowel++;
                res += consonant%1000000007;
            }else{
                consonant++;
                res += vowel%1000000007;
            }
        }
        return res%1000000007;
    }
}


