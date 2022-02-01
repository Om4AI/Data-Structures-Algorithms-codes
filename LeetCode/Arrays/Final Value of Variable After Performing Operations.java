class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s: operations){
            if(s.charAt(0)=='+' || s.charAt(2)=='+') x+=1;
            else x-=1;
        }
        return x;
    }
}
