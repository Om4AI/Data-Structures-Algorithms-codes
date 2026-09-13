import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        // Base case of single character
        if(senate.length()==1) return (senate.charAt(0)=='R')?"Radiant":"Dire";
        
        // Create StringBuffer
        StringBuffer sb = new StringBuffer(senate);

        // Find the occurences of R & D
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<sb.length(); i++){
            map.put(sb.charAt(i), map.getOrDefault(sb.charAt(i),0)+1);
        }
        // Only single character present
        if(map.size()==1) return (senate.charAt(0)=='R')?"Radiant":"Dire";

        // Loop through for playing rounds
        while(sb.length()!=1){
            String roundres = playRound(sb,map);
            sb = new StringBuffer(roundres);
        }

        return (sb.charAt(0)=='R')?"Radiant":"Dire";
    }



    public static String playRound(StringBuffer sb, HashMap<Character,Integer> map){
        StringBuffer res = new StringBuffer();
        int n = sb.length();

        for(int i=0; i<n; i++){
            char curr = sb.charAt(i);
            char next = sb.charAt((i+1)%n);

            if(curr=='a') continue;

            // Win declaration
            if(curr=='D' && map.get('R')==0) return "D";
            else if(curr=='R' && map.get('D')==0) return "R";

            // Ban other player
            if(curr!=next && next!='a'){
                sb.setCharAt((i+1)%n, 'a');
                map.put(next,map.get(next)-1);
                continue;
            }else{
                int nextdiff = findIndex(sb,i,curr,n);
                sb.setCharAt(nextdiff, 'a');
                char opp = (curr=='D')?'R':'D';
                map.put(opp,map.get(opp)-1);
            }            
        }
        

        // Form round result
        for(int i=0; i<n; i++){
            if(sb.charAt(i)!='a') res.append(sb.charAt(i));
        }
        return res.toString();
    }


    public static int findIndex(StringBuffer sb, int ci, char curr, int n){
        int f = 0, i = (ci+1)%sb.length();
        while(f==0){
            if(sb.charAt(i)!='a' && sb.charAt(i)!=curr){
                f = 1;
                return i;
            }
            i = (i+1)%n;
        }
        return i;
    }
}