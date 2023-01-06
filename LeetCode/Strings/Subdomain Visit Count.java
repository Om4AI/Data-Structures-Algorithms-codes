import java.util.*;

class Solution {
    public static HashMap<String,Integer> res;
    public List<String> subdomainVisits(String[] arr) {
        res = new HashMap<>();
        List<String> l = new ArrayList<>();

        // Main loop
        for(String s: arr){
            String[] temp = s.split(" ");
            int count = Integer.parseInt(temp[0]);

            // Full domain count modify
            res.put(temp[1], res.getOrDefault(temp[1], 0)+count);

            String doms[] = temp[1].split("\\.");
            if(doms.length==2) {
                res.put(doms[1], res.getOrDefault(doms[1], 0)+count);
            }
            else modifyMapThree(doms, count);
        }

        for(String k: res.keySet()){
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(res.get(k)));
            sb.append(" ");
            sb.append(k);
            l.add(sb.toString());
        }
        return l;
    }


    public static void modifyMapThree(String[] doms, int c){
        // Case 2: (b.c) subdomain
        StringBuffer sb = new StringBuffer(doms[1]);
        sb.append(".");
        sb.append(doms[2]);
        res.put(sb.toString(), res.getOrDefault(sb.toString(), 0)+c);

        // Case 3: (c) subdomain
        res.put(doms[2], res.getOrDefault(doms[2], 0)+c);
    }
}