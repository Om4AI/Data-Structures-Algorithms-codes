class Solution {
    public int minFlips(String target){
        // Find the first index of 1
        int index = target.length(), n = index;
        for(int i=0; i<n; i++){
            if(target.charAt(i)=='1'){
                index = i;
                break;
            }
        }
        
        // Case: All zeros (Index won't get updated)
        if(index==n) return 0;

        // Count the occurences
        int c = 1, el = '1';
        for(int i=index; i<n; i++){
            char curr = target.charAt(i);
            if(curr!=el){
                c++;
                el = curr;
            }
        }
        return c;
    }
}