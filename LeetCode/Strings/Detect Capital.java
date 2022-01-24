class Solution {
    public boolean detectCapitalUse(String word) {
        int c1 = 1, c2=1, c3=1;
        // Case 1
        for(int i=0; i<word.length(); i++) if(!Character.isUpperCase(word.charAt(i))) c1 = 0;
        for(int i=0; i<word.length(); i++) if(Character.isUpperCase(word.charAt(i))) c2 = 0;
        for(int i=1; i<word.length(); i++){
            if(i==0){
                if(!Character.isUpperCase(word.charAt(i))) c3 = 0;
            }else{
                if(Character.isUpperCase(word.charAt(i))) c3 = 0;
            }
        }

        return (c1==1||c2==1|c3==1);
    }
}