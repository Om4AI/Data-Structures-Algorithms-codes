import java.util.*;

class Word{
    String content;
    int len;
    Word(int length, String wordcon){
        content = wordcon;
        len = length;
    }
}

class Solution {

    public int minimumLengthEncoding(String[] words){
        // Sort the words according to their lengths
        // Create array of objects
        int n = words.length;
        Word[] objs = new Word[n];
        for(int i=0; i<n; i++){
            Word w = new Word(words[i].length(), words[i]);
            objs[i] = w;
        }

        // Sort
        Arrays.sort(objs, (a,b)->(b.len-a.len));

        List<String> taken = new ArrayList<>();
        int res = 0;
        
        // Start actual loop to check every word
        for(int i=0; i<n; i++){
            String w = objs[i].content;
            int wl = objs[i].len;
            if(substringPresent(w,taken)) continue;
            else{
                taken.add(w);
                res+=(wl+1);
            }
        }
        return res;
    }


    public static boolean substringPresent(String w, List<String> taken){
        for(int i=0; i<taken.size(); i++){
            if(isSubstring(w,taken.get(i))) return true;
        }
        return false;
    }

    public static boolean isSubstring(String w, String parent){

        if(parent.indexOf(w)==-1) return false;
        
        StringBuffer sb = new StringBuffer(parent);

        while(sb.length()>0){
            String s2 = sb.toString();
            int index = s2.indexOf(w);
            if(index==-1) return false;
            if(index+w.length()==s2.length()) return true;
            sb = new StringBuffer(s2.substring(index+1));
        }
        return false;
    }
}