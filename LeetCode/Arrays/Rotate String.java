class Solution {
    public boolean rotateString(String s, String goal) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        for (int i=1; i<=s.length(); i++){
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            list.add(sb.toString());
        }
        return list.contains(goal);
    }
}
