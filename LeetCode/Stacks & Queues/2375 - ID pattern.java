import java.util.Stack;

class Solution {
    static Stack<Integer> res;
    static Stack<Integer> desc_bag;
    public static void empty_bag(){
        while(!desc_bag.isEmpty()){
            res.add(desc_bag.pop());
        }
    }


    public String smallestNumber(String pattern) {
        res = new Stack<>();
        desc_bag = new Stack<>();

        // Pattern pointer & Number value
        int pp = 0;
        int num = 2;

        // Add first number
        res.add(1);

        while(pp<pattern.length()){
            // If next element is I
            if (pattern.charAt(pp)=='I'){
                empty_bag();
                res.add(num);
            }
            // If next element is D
            else if (pattern.charAt(pp)=='D'){
                int res_top = res.pop();
                desc_bag.add(res_top);
                res.add(num);
            }
            num++;
            pp++;
        }
        empty_bag();
        
        // Create final string
        StringBuffer result = new StringBuffer();
        while (!res.isEmpty()){
            result.append(Integer.toString(res.pop()));
        }
        return result.reverse().toString();
    }
}