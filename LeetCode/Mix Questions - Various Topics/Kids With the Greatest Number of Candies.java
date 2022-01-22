class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        // Find maximum
        for (int i:candies){
            if (i>max) max = i;
        }
        // Get balance
        for (int i=0; i<candies.length; i++) {candies[i] = max-candies[i];}
        List<Boolean> list = new ArrayList<Boolean>();
        
        for (int i=0; i<candies.length; i++){
            if (candies[i] <= extraCandies){list.add(true);}
            else{list.add(false);}
        }
        return list;
    }
}
