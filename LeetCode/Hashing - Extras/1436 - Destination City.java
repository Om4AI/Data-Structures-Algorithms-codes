import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        List<String> ends = new ArrayList<>();
        HashSet<String> starts = new HashSet<>();

        for (int i=0; i<paths.size(); i++){
            String start = paths.get(i).get(0);
            String end = paths.get(i).get(1);

            starts.add(start);
            ends.add(end);
        }

        for (String s: ends){
            if (!starts.contains(s)){
                return s;
            }
        }
        return null;
    }
}