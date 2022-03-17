import java.util.*;
class Solution {
    public boolean search(int[] nums, int target) {
        // Create remove duplicates using sorted set
        SortedSet<Integer> set = new TreeSet<>();
        for (int i: nums) set.add(i);

        // Create list for searching
        List<Integer> l = new ArrayList<>(set);

        // Binary Search
        int s = 0, e = l.size()-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(l.get(mid)==target) return true;
            else if (target>l.get(mid)) s = mid+1;
            else e = mid-1;
        }
        return false;
    }
}
