import java.util.*;

class Log{
    String s;
    String identifier;
    String content;
    Log(String og, String iden, String con){
        s = og;
        identifier = iden;
        content = con;
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs){
        // Traverse - Seperate and create Log objects
        List<String> digitLogs = new ArrayList<>();
        List<Log> letterLogs = new ArrayList<>();
        for(String s: logs){
            String arr[] = s.split(" ",2);
            char c = arr[1].charAt(0);
            if(Character.isDigit(c)) digitLogs.add(s);
            else{
                // Create Log object
                Log l = new Log(s,arr[0],arr[1]);
                letterLogs.add(l);
            }
        }
        
        // Comparator - Override original method (Internal)
        Comparator<Log> logComp = new Comparator<>(){
            @Override
            public int compare(Log l1, Log l2){
                String s1 = l1.content, s2 = l2.content;
                if(s1.equals(s2)){
                    return l1.identifier.compareTo(l2.identifier);
                }else{
                    return l1.content.compareTo(l2.content);
                }
            }
        };

        Collections.sort(letterLogs, logComp);
                         
        // Resultant logs
        List<String> resLogs = new ArrayList<>();
        for(Log l: letterLogs){
            resLogs.add(l.s);
        }
        
        // Add digit logs
        for(String dl: digitLogs) resLogs.add(dl);
        
        // Construct resultant string array
        String res[] = new String[resLogs.size()];
        for(int i=0; i<res.length; i++) res[i] = resLogs.get(i);
        return res;
    }
}
