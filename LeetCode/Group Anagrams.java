// Java Code: ArrayList & HashSet

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList();
        List<String> copy = new ArrayList();
        for (int i=0; i<strs.length; i++){
//             Sort each string
            String s = strs[i];
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String sortstr = new String(c);
            copy.add(sortstr);
        }
        HashSet<String> set = new HashSet(copy);
        for (String s: set){
            List<String> sub = new ArrayList<>();
            for (int i=0; i<copy.size(); i++){
                if (s.equals(copy.get(i))){
                    sub.add(strs[i]);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
