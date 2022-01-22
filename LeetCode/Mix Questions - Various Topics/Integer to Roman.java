// Integer to Roman: HashMap

import java.util.*;

class Solution {
    public String intToRoman(int num) {
        // Create the map of KV pairs
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int rem = num, j=0;
        int nums[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuffer r = new StringBuffer();
        // Logic
        while (rem > 0){
            if (map.containsKey(rem)) {
                r.append(map.get(rem));
                rem = 0;
            }

            else{
                int el=1000, f=0;
                // Check the value through array 
                for (int i=0; i<nums.length; i++){
                    if (rem==nums[i]){
                        f = 1;
                        el = nums[i];
                        break;
                    }
                    else if(rem < nums[i] && i!=0){
                        f = 1;
                        el = nums[i-1];
                        break;
                    }
                }
                if (f==0){
                    el = nums[nums.length-1]; 
                }
                // Element found
                int times = rem/el;
                // Add n times the element to the string
                for (int i=1; i<=times; i++){
                    r.append(map.get(el));
                }
                // Remainder
                rem = rem%el;
            }
        }
        return r.toString();
    }
}
