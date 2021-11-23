class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        String arr[] = s.split(" ");
        
        List<String> l = new ArrayList<>();
        for (String str: arr)l.add(str);
        Collections.reverse(l);
        StringBuffer sb = new StringBuffer();
        for (String s1: l){
            sb.append(s1);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
