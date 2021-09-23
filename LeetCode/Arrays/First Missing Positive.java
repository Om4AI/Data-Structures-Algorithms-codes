class Solution {
    public int firstMissingPositive(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int p = 1;
        while (true){
            if (!map.containsKey(p)){
                break;
            }else p++;
        }
        return p;
    }
}
