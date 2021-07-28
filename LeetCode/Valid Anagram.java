class Solution {
    public boolean isAnagram(String s, String t) {
//         String 1
        List<Character> l1 = new ArrayList();
        for (int i=0; i<s.length(); i++){l1.add(s.charAt(i));}
        Collections.sort(l1);
//         String 2
        List<Character> l2 = new ArrayList();
        for (int i=0; i<t.length(); i++){l2.add(t.charAt(i));}
        Collections.sort(l2);
        return l1.equals(l2);
    }
}
