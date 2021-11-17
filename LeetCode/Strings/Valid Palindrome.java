class Solution {
    public boolean isPalindrome(String s) {
        int f = 1;
        StringBuffer sb = new StringBuffer();
        String specialCharactersString = "!@#$%&*()'+,-./\":;<=>?[]^_`{|}";
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' ' || specialCharactersString.contains(String.valueOf(s.charAt(i)))){
                continue;
            }
            else{sb.append(Character.toLowerCase(s.charAt(i)));}
        }
        System.out.println(sb);
        int n = sb.length();
        for (int i=0; i<n/2; i++){
            if (sb.charAt(i) != sb.charAt(n-1-i)){
                f = 0;
                break;
            }
        }
        if (f == 0){return false;}
        else{return true;}
    }
}
