import java.util.*;
public class Solution {
	public void arrange(ArrayList<Integer> a) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<a.size(); i++){
            map.put(a.get(i),i);
        }

        for(int i=0; i<a.size(); i++){
            int index = map.get(map.get(i));
            a.set(index,i);
        }
	}
}
