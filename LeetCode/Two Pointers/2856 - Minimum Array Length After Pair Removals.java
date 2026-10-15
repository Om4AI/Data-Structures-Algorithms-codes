class Solution {
    public int minLengthAfterRemovals(List<Integer> list) {
        int n = list.size();
        int l = 0, r = n/2, res = 0;

        while (l<n/2 && r<n){
            if (list.get(r)>list.get(l)){
                l++;
                r++;
            }else if (list.get(r)<=list.get(l)){
                r++;
                res++;
            }
        }
        return res + n/2-l + (n-r);
    }
}