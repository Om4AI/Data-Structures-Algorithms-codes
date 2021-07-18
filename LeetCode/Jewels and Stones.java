// HashMap

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i=0; i<jewels.length(); i++){
            map.put(jewels.charAt(i), "jewel");
        }
        int c=0;
        for (int i=0; i<stones.length(); i++){
            if (map.containsKey(stones.charAt(i))) c++;
        }
        return c;
    }
}


// Array List
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        List<Character> list = new ArrayList<Character>();
        for (int i=0; i<jewels.length(); i++){
            list.add(jewels.charAt(i));
        }
        int c=0;
        for (int i=0; i<stones.length(); i++){
            if (list.contains(stones.charAt(i))) c++;
        }
        return c;
    }
}
