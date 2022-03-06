class Solution {
    public int minNumberOfFrogs(String s){
        int frogs = 0, avail_frogs=0;
        if(s.length()<5) return -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c=='c'){
                if(avail_frogs==0){
                    frogs++;
                }else if (avail_frogs>0) avail_frogs--;
                map.put(c, map.getOrDefault(c, 0)+1);
            }else if(c=='k'){
                avail_frogs++;
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            else map.put(c, map.getOrDefault(c, 0)+1);

            // Check order
            if(!checkOrder(map)) return -1; 
        }

        // Check for valid croaks
        if(map.size()<5) return -1;
        int count = map.get('c');
        for(Character k: map.keySet()){
            if(map.get(k)!=count) return -1;
        }
        return frogs;
    }

    public static boolean checkOrder(HashMap<Character, Integer> map){
        if(map.size()>=1 && !map.containsKey('c')) return false;

        char arr[] = {'c','r','o','a','k'};
        int pcount = map.get('c');
        for(int i=0; i<5; i++){
            char c = arr[i];
            if(map.containsKey(c) && map.get(c)>pcount) return false;
            
            // Modify pcount
            pcount = map.containsKey(c) ? map.get(c):0;
        }
        return true;
    }
}