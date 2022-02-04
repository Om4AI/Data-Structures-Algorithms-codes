class Solution {
    public int findMaxLength(int[] arr){
        int n = arr.length, pos =0, max_len=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            // Insert first position of the current position
            if(!map.containsKey(pos)){
                map.put(pos, i);
            }

            // Change position
            if(arr[i]==0) pos--;
            else pos++;

            // Check previous occurence
            if(map.containsKey(pos)){
                max_len = Math.max(max_len, i-map.get(pos)+1);
            }
        }
        return max_len;
    }
}