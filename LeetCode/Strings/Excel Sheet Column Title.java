class Solution {
    public String convertToTitle(int col) {
        String res = "";
        while(col!=0){
            col--;
//             65 fr ASCII chars range
            char c = (char)((col % 26) + 65);
            res = c+res;
//             Reduce the range
            col/=26;
        }
        return res;
    }
}