public class Solution {
	public int searchInsert(ArrayList<Integer> l, int target){
        // Parameters
        int n = l.size();
        int s = 0, e = n-1;

        // Initial Conditions - Base Cases
        if(target<l.get(0)) return 0;
        if (target>l.get(n-1)) return n;

        // Find target element
        while(s<=e){
            int mid = s+(e-s)/2;
            if(l.get(mid)==target) return mid;
            else if (target>l.get(mid)) s = mid+1;
            else e = mid-1;
        }

        // Element not found
        // Find closest greater element
        s = 0;
        e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(l.get(mid)>target){
                // Elements are inserted before and then current mid is inserted so mid must be returned
                if(l.get(mid-1)<target) return mid;
                else e = mid-1;
            }else if(l.get(mid)<target) s = mid+1; 
        }
        return -1;
	}
}
