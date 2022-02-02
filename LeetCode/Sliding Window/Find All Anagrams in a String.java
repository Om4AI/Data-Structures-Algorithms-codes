class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        
        // Base condition
        if(k>s.length()) return res;
        
        StringBuffer sb = new StringBuffer();
        p = sortStr(p);

        // Add first sliding window
        for (int i=0; i<k; i++) sb.append(s.charAt(i));
        String temp = sortStr(sb.toString());
        if(temp.equals(p)) res.add(0);

        for(int i=1; i<=s.length()-k; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i+(k-1)));
            temp = sortStr(sb.toString());
            if(temp.equals(p)) res.add(i);
        }
        return res;
    }

    public static String sortStr(String s){
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        s = String.valueOf(arr);
        return s;
    }
}
