public class Solution {
    public long countSalutes(String s){
        long curr = 0;
        long res= 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='>') curr++;
            else res+=curr;
        }
        return res;
    }
}
