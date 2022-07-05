import java.util.*;
// --------------------- Time Complexity - O(nlogn)---------------------
class Solution {
    public int longestConsecutive(int[] arr) {
        // Base Case
        int n = arr.length, res = 1;
        if(n==0) return 0;
        
        // Remove duplicates & sort elements
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) set.add(i);
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        
        // Longest AP with given difference - 1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<l.size(); i++){
            int prev = l.get(i)-1;
            int c = map.getOrDefault(prev,0)+1;
            map.put(l.get(i),c);
            res = Math.max(res,c);
        }
        return res;
    }
}
// ----------------------------------------------------------------------

// ----------------------- Time Complexity O(n) -------------------------
class Solution {
    public int longestConsecutive(int[] nums){
        // Remove duplicates
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        
        int res = 0;
        for(int num: set){
            int currstreak = 1;
            int curr = num;
            if(!set.contains(num-1)){
                while(set.contains(curr+1)){
                    currstreak++;
                    curr++;
                }
            }
            res = Math.max(res,currstreak);
        }
        return res;
    }
}
// ------------------------------------------------------------------------