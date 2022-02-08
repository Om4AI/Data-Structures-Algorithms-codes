class Solution {
    public int addDigits(int num){
        String n = String.valueOf(num);
        int res = 0;
        
        while(n.length()>1){
            for (int i=0; i<n.length(); i++){
                res += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
            n = String.valueOf(res);
            res = 0;
        }
        return Integer.parseInt(n);
    }
}
