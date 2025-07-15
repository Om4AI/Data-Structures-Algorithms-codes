class Solution {
    public boolean isValid(String word) {
        word = word.toLowerCase();
        if (word.length()<3) {return false;}
        boolean vow = false;
        boolean con = false;
        
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!Character.isDigit(c) && !Character.isLetter(c)){
                return false;
            }else{
                if(Character.isLetter(c)){
                    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                        vow = true;
                    }else{
                        con = true;
                    }
                }
            }
        }
        return vow==true && con==true;
    }
}
