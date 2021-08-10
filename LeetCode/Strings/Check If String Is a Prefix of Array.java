class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i<words.length && !sb.toString().equals(s)){
            sb.append(words[i]);
            i++;
        }
        return s.equals(sb.toString());
    }
}
