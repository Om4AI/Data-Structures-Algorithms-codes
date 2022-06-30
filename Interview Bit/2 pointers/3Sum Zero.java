class Solution {
    public int[][] threeSum(int[] arr) {
        
        // Select first element from array
        int n = arr.length;
        HashSet<List<Integer>> res = new HashSet<>();

        for(int i=0; i<n-2; i++){
            
            // Condition of outside Integer range
            long k1 = (long)0 - arr[i];
            if(k1<Integer.MIN_VALUE || k1>Integer.MAX_VALUE) continue;
            int k = (int)k1;

            List<List<Integer>> twosums = twoSum(arr,i+1,k);
            for(List<Integer> l: twosums){
                List<Integer> t = new ArrayList<>();
                t.add(arr[i]);
                t.addAll(l);
                Collections.sort(t);
                res.add(t);
            }
        }
        List<List<Integer>> r = new ArrayList<>(res);
        int[][] ares = new int[r.size()][3];
        for(int i=0; i<r.size(); i++){
            List<Integer> temp = r.get(i);
            ares[i][0] = temp.get(0);
            ares[i][1] = temp.get(1);
            ares[i][2] = temp.get(2);
        }
        return ares;
    }


    public static List<List<Integer>> twoSum(int[] a, int index, int k){
        // Create array - arr
        int[] arr = new int[a.length-index];
        int p = 0;
        for(int i=index; i<a.length; i++){
            arr[p] = a[i];
            p++;
        }

        // Find all two sums
        HashSet<List<Integer>> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            int el = arr[i];
            if(set.contains(el)){
                List<Integer> l = new ArrayList<>();
                l.add(el);
                l.add(k-el);
                res.add(l);
            }else set.add(k-el);
        }

        return new ArrayList<>(res);
    }
}
