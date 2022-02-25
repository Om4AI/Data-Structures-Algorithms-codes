class Solution {
    public int countOdds(int a, int b) {
        // 4 cases
        if(a%2==0 && b%2==0) return (int)Math.ceil((double)(b-a-1)/2);
        else if(a%2!=0 && b%2!=0) return 2+(int)Math.floor((double)(b-a-1)/2);
        else return 1+((b-a-1)/2);        
    }
}
