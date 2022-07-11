import java.util.*;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<t.length; i++) Arrays.fill(t[i], -1);
        return minAscii(s1,s2,0,0,t);
    }


    public static int minAscii(String s1, String s2,int in1, int in2,int[][] t){
        // Base case
        if(in1==s1.length() || in2==s2.length()){
            int sum = 0;
            while(in1<s1.length()){
                sum+=(int)s1.charAt(in1);
                in1++;
            }

            while(in2<s2.length()){
                sum+=(int)s2.charAt(in2);
                in2++;
            }
            return t[in1][in2] = sum;
        }

        // Memoization check
        if(t[in1][in2]!=-1) return t[in1][in2];


        // General case
        if(s1.charAt(in1)!=s2.charAt(in2)){
            return t[in1][in2] = Math.min((int)s1.charAt(in1)+minAscii(s1,s2,in1+1,in2,t), (int)s2.charAt(in2)+minAscii(s1,s2,in1,in2+1,t));
        }else{
            return t[in1][in2] = minAscii(s1,s2,in1+1,in2+1,t);
        }
    }
}