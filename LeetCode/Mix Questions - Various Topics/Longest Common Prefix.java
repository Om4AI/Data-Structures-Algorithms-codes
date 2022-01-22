class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int f = 0;
        if (strs.length == 0){
            return ("");
        }
        else{
            // Find the minimum length in strings
            int min = 99999;
            for (int i=0;i<strs.length; i++){
                if (strs[i].length() < min){
                    min = strs[i].length();
                }
            }

            String s = strs[0];
            // Parse string
            for (int j =0; j<min; j++){
                // Parse array of strings
                for (int i =1; i<strs.length; i++){
                    if (s.charAt(j) != (strs[i]).charAt(j)){
                        f = 1;
                        break;
                    }
                }
                // Inner loop complete
                if (f==1){
                    break;
                }
                else{
                    sb.append(s.charAt(j));
                }
            }
    
            return (sb.toString());
        }
        
    }
}
