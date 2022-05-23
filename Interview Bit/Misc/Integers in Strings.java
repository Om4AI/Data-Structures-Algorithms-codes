public class Solution {
    public int[] solve(String s) {
        String arr[] = s.split(",");
        int res[] = new int[arr.length];

        for(int i=0; i<arr.length; i++) res[i] = Integer.parseInt(arr[i]);
        return res;
    }
}
