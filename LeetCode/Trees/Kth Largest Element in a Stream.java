// Code by @Om

class KthLargest {
    
    List<Integer> list = new ArrayList();
    int kth = 0, res = Integer.MIN_VALUE;
    public KthLargest(int k, int[] nums) {
        for (int i:nums) list.add(i);
        kth = k;
    }
    
    public int add(int val) {
        if (val<=res) return res;
        else{
            list.add(val);
            Collections.sort(list);
            res = list.get(list.size()-kth);
            return res;
        }
    }
}

// Optimized Solution
