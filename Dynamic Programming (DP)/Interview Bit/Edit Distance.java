import java.util.*;

class Solution {
    public int minDistance(String s1, String s2){
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length(); i++) Arrays.fill(t[i],-1);

        return minOps(s1,s2,0,0,t);
    }


    public static int minOps(String s1, String s2, int i1, int i2, int[][] t){
        // Base case
        if(i1 ==s1.length() && i2<s2.length()){
            return t[i1][i2] = s2.length()-i2;
        }else if(i1<s1.length() && i2==s2.length()) return t[i1][i2] = s1.length()-i1;
        else if(i1==s1.length() && i2==s2.length()) return t[i1][i2] = 0;

        // Memoization check
        if(t[i1][i2] !=-1) return t[i1][i2];

        // General case
        char c1 = s1.charAt(i1), c2 = s2.charAt(i2);

        if(c1==c2) return minOps(s1,s2,i1+1,i2+1,t);
        else{
            int temp = Math.min(1+minOps(s1,s2,i1+1,i2,t), 1+minOps(s1,s2,i1+1,i2+1,t));
            return t[i1][i2] = Math.min(temp, 1+minOps(s1,s2,i1,i2+1,t));
        }
    }
}