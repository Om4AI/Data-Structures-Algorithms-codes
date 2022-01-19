class Solution {
    public String[] divideString(String s, int k, char fill){
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int q = s.length()/k, i=1;
        while(i<=q){
            res.add(s.substring((i*k-k), i*k));
            i++;
        }
        if(q*k<s.length()){
            for(int j=q*k; j<s.length(); j++) sb.append(s.charAt(j));
        }
        if(sb.length()>=1 && sb.length()<k){
            while(sb.length()<k) sb.append(fill);
            res.add(sb.toString());
        }
        String str[] = new String[res.size()];
        for(i=0; i<res.size(); i++) str[i] = res.get(i);
        return str;
    }
}
