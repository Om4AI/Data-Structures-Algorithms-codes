import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,List<Integer>> map = new HashMap<>();
        HashMap<String,Integer> wordFreq = new HashMap<>();
        for(String i: words){
            wordFreq.put(i, wordFreq.getOrDefault(i,0)+1);
        }
        
        // Fill up the HashMap with indices of starting of every word in the string
        for(String w:words){
            map.put(w,getIndices(w,s));
        }

        // Create groups map
        HashMap<Integer, Integer> groups = new HashMap<>();
        HashMap<Integer,Integer> grpLen = new HashMap<>();
        HashMap<Integer,String> strGrp = new HashMap<>();
        int p = 1;
        List<Integer> indices = new ArrayList<>();
        for(String k:map.keySet()){
            List<Integer> l = map.get(k);
            grpLen.put(p,k.length());
            for(int i:l){
                groups.put(i,p);
                indices.add(i);
                strGrp.put(p,k);
            }
            p++;
        }
        Collections.sort(indices);
        if(indices.size()==0) return new ArrayList<>();


        // Get the groups & check continuity
        List<Integer> l = new ArrayList<>();
        l.add(groups.get(indices.get(0)));

        for(int i=1; i<indices.size(); i++){
            int len = grpLen.get(groups.get(indices.get(i-1))), prev = indices.get(i-1), curr = indices.get(i);
            int temp = prev+len;
            if(!indices.contains(temp)){
                l.add(0);
                l.add(groups.get(indices.get(i)));
            }
            else if(temp==curr) l.add(groups.get(indices.get(i)));
            else if(temp>curr){
                l.add(groups.get(indices.get(temp)));
                i=temp;
            }
        }
        
        String arr[] = new String[l.size()];
        for(int i=0; i<l.size(); i++){
            if(l.get(i)==0) arr[i] = "trivial";
            else arr[i] = strGrp.get(l.get(i));
        }
        
        List<Integer> resInd = getStarts(arr,l.size(),words.length,wordFreq,indices);
        
        return resInd;
    }


// --------------------------------------------------------Function 2------------------------------------------------------
    public static List<Integer> getStarts(String[] arr, int n, int k,HashMap<String,Integer> wordFreq,List<Integer> indices){

        // Result List
        List<Integer> res = new ArrayList<>();
        if(n<k) return res;

        // Create Sliding Window
        HashMap<String,Integer> map = new HashMap<>();
        int s = 0, e = k, zeros = 0;
        for(int i=0; i<k; i++){
            if(arr[i].equals("trivial")) zeros++;
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        if(map.equals(wordFreq)){
            res.add(indices.get(s));
        }

        while(s<e && e<n){

            // Update map
            String rem = arr[s], nadd = arr[e];
            
            // System.out.println(map);

            if(map.get(rem)==1) map.remove(rem);
            else map.put(rem, map.get(rem)-1);

            if(map.containsKey(nadd)){
                map.put(nadd, map.get(nadd)+1);
            }else map.put(nadd, 1);
            if(nadd.equals("trivial")) zeros++;

            // Check if current window is correct
            if(map.equals(wordFreq)){
                res.add(indices.get(s+1-zeros));
            }

            // Update start & end points
            s++;
            e++;
        }
        return res;
    }

// ----------------------------------------------------Function 3----------------------------------------------------------
    public static List<Integer> getIndices(String word, String s){
        StringBuffer sb = new StringBuffer();
        List<Integer> indices = new ArrayList<>();
        int k = word.length(), n = s.length();
        
        // Create first window
        for(int i=0; i<k; i++){
            sb.append(s.charAt(i));
        }
        if(sb.toString().equals(word)) indices.add(0);
        int st = 0, e = k;
        while(e<n){
            sb.deleteCharAt(0);
            sb.append(s.charAt(e));

            if(sb.toString().equals(word)) indices.add(st+1);
            e++;
            st++;
        }

        return indices;
    }
}
