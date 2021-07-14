//Code by @Om Mule

class Solution {
    public String customSortString(String order, String str) {
        StringBuffer result = new StringBuffer();
        StringBuffer sb = new StringBuffer();

        // sb contains the str string
        sb.append(str);

        for (int i=0; i<order.length(); i++){
            char el = order.charAt(i);
            // Compare with the str buffer
            for (int j=0; j<sb.length(); j++){
                if (sb.charAt(j) == el){
                    result.append(el);
                }
            }
            str = str.replaceAll(String.valueOf(el), "");
        }
        result.append(str);
        return result.toString();
    }
}
