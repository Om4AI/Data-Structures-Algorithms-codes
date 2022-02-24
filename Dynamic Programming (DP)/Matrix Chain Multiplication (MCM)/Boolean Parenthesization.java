import java.util.*;
class Solution{
    public static int mod = 1003;
    static int countWays(int n, String s){
        // Find i & j values
        int i=0, j=n-1;
        HashMap<String, Integer> map = new HashMap<>();
        return boolean_paren(s,n,i,j,true,map);
    }

    public static int boolean_paren(String s,int n, int i, int j, boolean isTrue, HashMap<String, Integer> map){
        // Base condition
        if(i>j) return 0;
        if(i==j){
            if(isTrue==true){
                if(s.charAt(i)=='T') return 1;
                else return 0;
            }else{
                if(s.charAt(i)=='F') return 1;
                else return 0;
            }
        }

        // Memoization value checking
        // Create key for map check
        StringBuffer sb = new StringBuffer(Integer.toString(i));
        sb.append(" ");
        sb.append(Integer.toString(j));
        sb.append(" ");
        sb.append(Boolean.toString(isTrue));
        String temp = sb.toString();
        // Find value in the map
        if(map.containsKey(temp)) return map.get(temp);

        int ans = 0;
        // Actual K values change & operations
        for(int k=i+1; k<=j-1; k+=2){
            int LT = boolean_paren(s,n,i,k-1,true,map);
            int LF = boolean_paren(s,n,i,k-1,false,map);
            int RT = boolean_paren(s,n,k+1,j,true,map);
            int RF = boolean_paren(s,n,k+1,j,false,map);

            if(s.charAt(k)=='&'){
                if(isTrue==true){
                    ans = ans+(LT*RT)%mod;
                }else{
                    ans = ans+(LT*RF)%mod+(LF*RT)%mod+(LF*RF)%mod;
                }
            }else if(s.charAt(k)=='|'){
                if(isTrue==true){
                    ans = ans+(LT*RF)%mod+(LF*RT)%mod+(LT*RT)%mod;
                }else{
                    ans = ans+(LF*RF)%mod;
                }
            }else{
                if(isTrue==true){
                    ans = ans+(LT*RF)%mod+(LF*RT)%mod;
                }else{
                    ans = ans+(LF*RF)%mod+(LT*RT)%mod;
                }
            } 
        }
        map.put(temp, ans%mod);
        return map.get(temp);
    }
}