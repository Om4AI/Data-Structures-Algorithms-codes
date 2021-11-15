import java.util.*;
class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> v1 = getRevisions(version1);
        List<String> v2 = getRevisions(version2);
        int v1l=v1.size(), v2l=v2.size(), i=0;

        // Compare till both lists exist
        while(v1l>0 && v2l>0){

            // Compare and return
            if(Integer.parseInt(v1.get(i)) > Integer.parseInt(v2.get(i))) return 1;
            else if(Integer.parseInt(v1.get(i)) < Integer.parseInt(v2.get(i))) return -1;
            v1l--;
            v2l--;
            i++;
        }

        // If v1l>v2l
        while(v1l>0){
            if(Integer.parseInt(v1.get(i))>0) return 1;
            i++;
            v1l--;
        }

        // If v2l>v1l
        while(v2l>0){
            if(Integer.parseInt(v2.get(i))>0) return -1;
            i++;
            v2l--;
        }
        return 0;
    }

    // Function to seperate Version Number into Revisions
    public List<String> getRevisions(String s){
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='.'){
                list.add(sb.toString());
                sb.setLength(0);
            }else sb.append(c);
        }
        list.add(sb.toString());
        return list;
    } 
}
