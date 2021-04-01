class Solution {
    public int lengthOfLastWord(String s) {
        if (s.trim().isEmpty()){
            return 0;
        }
        else{
           String[] s1 =s.split(" ");
           return (s1[s1.length-1].length());
        } 
    }
}
