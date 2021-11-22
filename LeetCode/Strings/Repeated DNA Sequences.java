// Runtime - 55ms

class Solution {
    public List<String> findRepeatedDnaSequences(String s){
        
//         Using the Sliding Window concept
        if(s.length()<=10) return new ArrayList<>();
        
        StringBuffer swin = new StringBuffer(s.substring(0,10));
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        
        set.add(swin.toString());
        
        for(int end=10; end<s.length(); end++){
   
//             Create new string
            swin.deleteCharAt(0);
            swin.append(s.charAt(end));
            
//             Check previous
            if(set.contains(swin.toString())) res.add(swin.toString());
            else set.add(swin.toString());
        }
        return new ArrayList<>(res);
    }
}

// Runtime 22 ms
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s.length()<=10) return new ArrayList<String>();
        
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        
        for (int i=0; i<=s.length()-10; i++){
            String s1 = s.substring(i, i+10);
            if(set.contains(s1)) res.add(s1);
            else set.add(s1);
        }
        return new ArrayList<>(res);
    }
}
