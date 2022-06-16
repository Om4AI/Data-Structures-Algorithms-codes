class Solution {
    public int numRabbits(int[] arr){
        // Count the occurences of a certain number told by rabbits
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        

        // Count the minimum number of rabbits using some Maths
        int c = 0;
        for(int k: map.keySet()){
            int occ = map.get(k);
            // Single set of rabbits
            if(occ<=k+1) c+=k+1;
            // More than (k+1) rabbits
            else{
                int t = (int)Math.ceil((float)occ/(k+1))*(k+1);
                c+=t;
            }
        }
        return c;
    }
}