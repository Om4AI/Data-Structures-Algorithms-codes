// Java Code: ArrayList & HashMap (Position maintain)


class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        
        List<List<String>> res = new ArrayList<>();
//         Pass through the array to create the HashMap
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int p = 0;
        for (int i=0; i<arr.length; i++){
            char c[] = arr[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            list.add(s);
            
//             Put into HashMap
            if(!map.containsKey(s)){
                map.put(s, p);
                p++;
            }
        }
        
//         Create a series of lists 
        for (int i=0; i<p; i++){
            res.add(new ArrayList<String>());
        }
        
        for (int i=0; i<arr.length; i++){
            String st = list.get(i);
            int pos = map.get(st);
            
            List<String> nl = new ArrayList<>();
            nl.addAll(res.get(pos));
            nl.add(arr[i]);
            res.set(pos,nl);
        }
        return res;
    }
}
