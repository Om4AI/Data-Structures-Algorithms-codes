class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int pos = 0;
        
//         Previous numbers
        for(int i=1; i<n; i++){
            pos+=Math.pow(26,i);
        }
        
//         Elements with same length but earlier
        for(int i=0; i<n; i++){
            int cnum = s.charAt(i);
            cnum-=64;
            int pow = (n-i-1);
            pos+=(cnum-1)*Math.pow(26,pow);
        }
        
        return pos+1;
    }
}
