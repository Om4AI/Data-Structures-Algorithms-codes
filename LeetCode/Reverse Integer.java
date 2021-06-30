class Solution {
    public int reverse(int n) {
        
        String s = String.valueOf(n);
        int len = 0;
        if (s.charAt(0)=='-'){len = s.length()-1;}
        else{len = s.length();}
        int reversed = 0, p = len-1;
        for (int i=0; i<len; i++){
            int rem = n % 10;
            reversed += (rem * Math.pow(10,p));
            p-=1;
            n = n/10;
        }
        // System.out.println(reversed);
        if (reversed <= -2147483648 || reversed >= 2147483647){return 0;}
        else{ return reversed;}
    }
}
