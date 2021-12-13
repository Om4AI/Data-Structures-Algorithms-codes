class Solution {
    public int maxPower(String s) {
        int max = 0, count=1;
//         Base case
        if(s.length()==1) return 1;
        
        char c = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char t = s.charAt(i);
            if(t==c) count++;
            else if(t!=c){
                max = Math.max(max, count);
                count=1;
                c = t;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
