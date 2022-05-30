class Solution {
    public String makeGood(String s){
        StringBuffer sb = new StringBuffer();
        
        while(!madeGood(s)){
            for(int i=0; i<s.length(); i++){
                
                if(i==s.length()-1) sb.append(s.charAt(i));
                else{
                    char c1 = s.charAt(i), c2 = s.charAt(i+1);
                    if(Character.toLowerCase(c1)==Character.toLowerCase(c2) && ((Character.isLowerCase(c1) && Character.isUpperCase(c2))||(Character.isUpperCase(c1) && Character.isLowerCase(c2)))) i++;
                    else{
                        sb.append(c1);
                    }
                }
            }
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
    
    public static boolean madeGood(String s){
        for(int i=0; i<s.length()-1; i++){
            char c1 = s.charAt(i), c2 = s.charAt(i+1);
                
            if(Character.toLowerCase(c1)==Character.toLowerCase(c2) && ((Character.isLowerCase(c1) && Character.isUpperCase(c2))||(Character.isUpperCase(c1) && Character.isLowerCase(c2)))) return false;
        }
        
        return true;
    }
}