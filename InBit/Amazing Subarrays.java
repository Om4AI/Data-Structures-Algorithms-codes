public class Solution {
    public int solve(String s){
        int c = 0, n = s.length();
        List<Character> l = new ArrayList<>();
        l.add('a');
        l.add('e');
        l.add('i');
        l.add('o');
        l.add('u');
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(l.contains(s.charAt(i))) c+=(n-i);
        }
        return c%10003;
    }
}
