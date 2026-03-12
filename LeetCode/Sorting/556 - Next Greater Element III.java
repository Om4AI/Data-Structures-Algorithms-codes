import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        // Create integer array
        ArrayList<Integer> list = new ArrayList<>();
        String s = String.valueOf(n);
        for (int i=0; i<s.length(); i++){
            list.add(Character.getNumericValue(s.charAt(i)));
        }

        // Pass 1 (find the element)
        int list_size = list.size();
        int max_el = 0;
        int index = -1;
        for (int i=list_size-1; i>=0; i--){
            int curr = list.get(i);
            if (curr < max_el){
                index = i;
                break;
            }else if (curr > max_el){
                max_el = curr;
            }
        }

        // Edge case (no greater element found)
        if (index == -1) return -1;

        // Pass 2 (find smallest greater element)
        int min_diff = Integer.MAX_VALUE;
        int min_ind = index;
        int el = list.get(index);
        for (int i=list_size-1; i>index; i--){
            int curr = list.get(i);
            if (el < curr){
                if ((curr-el) < min_diff){
                    min_diff = (curr-el);
                    min_ind = i;
                }
            }
        }

        // Swap the elements
        Collections.swap(list, index, min_ind);

        // Sort the sublit
        List<Integer> sublist = list.subList(index+1, list_size);
        Collections.sort(sublist);

        // Check if it can fit Integer
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = (res * 10) + list.get(i);
        }

        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        // Explicitly cast to int here
        return (int) res;
    }
}