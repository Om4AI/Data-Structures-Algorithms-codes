class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        int n1 = s.length();
        if(n1==1) return true;
        int f = 1;
        for(int i=0; i<n1; i++){
            if(i==0){
                if(s.charAt(i)==s.charAt(i+1)) f=0;
            }else if (i==n1-1){
                if(s.charAt(i)==s.charAt(i-1)) f=0;
            }else{
                if((s.charAt(i)==s.charAt(i+1)) || (s.charAt(i)==s.charAt(i-1))) f=0;
            }
        }
        return f==1;
    }
}
