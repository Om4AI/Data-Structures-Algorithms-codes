class Solution {
    public int[] distributeCandies(int candies, int n) {
        int arr[]  = new int[n];
        int req = 1, c=0;
        while(candies>=req){
            arr[c%n]+=req;
            candies-=req;
            req++;
            c++;
        }
        arr[c%n]+=candies;
        return arr;
    }
}
