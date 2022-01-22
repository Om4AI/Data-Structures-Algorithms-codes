import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> order){
        // Food Items list & Sort
        HashSet<String> set = new HashSet<>();
        int n = order.size();
        for(int i=0; i<n; i++) set.add(order.get(i).get(2));
        List<String> food = new ArrayList<>(set);
        Collections.sort(food);
        int f = food.size();

        // Create Map and fill with lists of 0s'
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<Integer> zeroes = new ArrayList<>(Arrays.asList(new Integer[f]));
            Collections.fill(zeroes, 0);
            map.put(Integer.parseInt(order.get(i).get(1)), zeroes);
        }

        // Modify map according to orders
        for(int i=0; i<n; i++){
            String fi = order.get(i).get(2);
            int tno = Integer.parseInt(order.get(i).get(1));
            int fiindex = food.indexOf(fi);
            
            // Get list for that table number
            List<Integer> temp = map.get(tno);
            temp.set(fiindex, temp.get(fiindex)+1);
            
            // Put the list back
            map.put(tno, temp);
        }

        // Results preparation
        List<List<String>> res = new ArrayList<>();
        List<List<String>> t = new ArrayList<>();
        // Food Items list
        food.add(0, "Table");
        res.add(food);

        // Create lists from the map
        for(int k: map.keySet()){
            List<Integer> teml = map.get(k);
            List<String> s = new ArrayList<>();
            for(int num: teml) s.add(String.valueOf(num));
            s.add(0, String.valueOf(k));
            t.add(s);
        }
        Collections.sort(t, (a,b)-> Integer.parseInt(a.get(0))-Integer.parseInt(b.get(0)));
        res.addAll(t);
        return res;
    }
}
