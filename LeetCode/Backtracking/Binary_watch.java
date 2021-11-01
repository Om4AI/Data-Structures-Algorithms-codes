class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        if (num<0||num>10)return res;

        for (int i=0; i<=11; i++){
            for (int j=0; j<=59; j++){
                if (Integer.bitCount(i)+Integer.bitCount(j)==num){
                    res.add(String.format("%d:%02d",i, j));
                }
            }
        }
        return res;
    }
}