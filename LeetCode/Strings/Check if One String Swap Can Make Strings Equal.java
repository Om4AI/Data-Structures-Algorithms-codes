class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()==1 && !s1.equals(s2)) return false;
        char a='x',b='x';
        int c = 0, i=0;
        
        while(i<s1.length() && c<=2){
            if(s1.charAt(i)!=s2.charAt(i)){
                c++;
                if(c==1){
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                }else{
                    if(s2.charAt(i)!=a || s1.charAt(i)!=b) return false;
                }
            }
            i++;
        }
        if(c==1) return false;
        return (c>2)? false: true;
    }
}
