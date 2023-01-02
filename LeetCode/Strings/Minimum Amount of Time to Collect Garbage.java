import java.util.*;

class Info{
    int last;
    int occ;
    Info(int l, int o){
        last = l;
        occ = o;
    }
}


class Solution {
    public int garbageCollection(String[] garbage, int[] travel){
        HashMap<Character,Info> map = new HashMap<>();
        map.put('P',new Info(0,0));
        map.put('M',new Info(0,0));
        map.put('G',new Info(0,0));
        int res = 0;
        
        // Combine the strings
        StringBuffer temp = new StringBuffer();
        for(int i=0; i<garbage.length; i++) temp.append(garbage[i]);
        String s = temp.toString();

        // Traverse the string and fill hashmap
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            Info obj = map.get(c);
            obj.occ+=1;
            obj.last = i;
            map.put(c, obj);
        }

        // Total travel time 
        res += getTravelTime(travel,'M',map,garbage) + getTravelTime(travel,'P',map,garbage) + getTravelTime(travel,'G',map,garbage);
        res += map.get('M').occ + map.get('P').occ + map.get('G').occ;
        return res;
    }


    public static int getTravelTime(int[] travel, char c, HashMap<Character,Info> map, String[] arr){
        int n = arr.length;
        int l = map.get(c).last;
        int tt = 0;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=arr[i].length();
            if(l<=sum-1){
                return tt;
            }else tt+=travel[i];
        }
        return tt;
    }
}