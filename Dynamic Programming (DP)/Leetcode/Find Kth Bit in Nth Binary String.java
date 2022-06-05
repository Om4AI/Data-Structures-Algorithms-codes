
// Memoization (Top Down Approach)
class Solution {
    static HashMap<Integer, String> map = new HashMap<>();
    public char findKthBit(int n, int k){
        return generateString(n).charAt(k-1);
    }
    

    public static String generateString(int n){
        
        if(map.containsKey(n)) return map.get(n);
        
        // Base case
        if(n==1){
            map.put(n,"0");
            return map.get(n);
        }
        
        // New String calculation
        StringBuffer sb = new StringBuffer();
        String s = generateString(n-1);
        sb.append(s);
        sb.append("1");
        // Reverse the S(n-1) string
        StringBuffer temp = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0') temp.append('1');
            else temp.append('0');
        }
        sb.append(temp.reverse().toString());
        //Store value in HashMap
        map.put(n,sb.toString());
        
        // Return result
        return map.get(n);
    }
}