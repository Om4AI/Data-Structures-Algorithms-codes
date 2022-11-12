import java.util.*;

class Solution {
    public int longestPalindrome(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0, odd = 0;

        // Fill the hashmap
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i=0; i<arr.length; i++){
            String el = arr[i];
            String rev = reverse(el);
            if(map.containsKey(el) && !el.equals(rev) && map.containsKey(rev)){
                len+=(4*Math.min(map.get(el), map.get(rev)));
                map.remove(rev);
            }else if(map.containsKey(el) && el.equals(rev)){
                int count = map.get(el);
                if(count%2==0) len+=(count*2);
                else{
                    len+= (2*(count-1));
                    odd=1;
                }
            }
            map.remove(el);
        }
        return (odd==1)?len+2:len;
    }

    public static String reverse(String s){
        return new StringBuffer(s).reverse().toString();
    }
}