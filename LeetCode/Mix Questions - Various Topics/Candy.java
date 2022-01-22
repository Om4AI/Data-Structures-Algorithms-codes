class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum=0;
        int candies[] = new int[n];
        for (int i=0; i<n; i++){candies[i] = 1;}
        // Left Check
        for (int i=1; i<n; i++){
            if ((ratings[i]>ratings[i-1]) && (candies[i]<=candies[i-1])){candies[i]=candies[i-1]+1;}
        }

        // Right Check
        for (int i=n-2; i>=0; i--){
            if (ratings[i]>ratings[i+1] && (candies[i]<=candies[i+1])){candies[i]=candies[i+1]+1;}
        }
        for (int i:candies){sum+=i;}
        return sum;
    }
}
