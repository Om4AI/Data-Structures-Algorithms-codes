public class Solution {
    public int solve(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int el = arr[i];
            map.put(el, map.getOrDefault(el,0)+1);
            
            map.put(el+k, map.getOrDefault(el+k,0)+1);
            
            map.put(el-k, map.getOrDefault(el-k,0)+1);
        }
        
        for(int key: map.keySet()){
            if(map.get(key)==arr.length) return 1;
        }
        return 0;
    }
}
