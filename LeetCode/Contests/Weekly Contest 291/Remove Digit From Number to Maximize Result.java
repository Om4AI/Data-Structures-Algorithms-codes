class Solution {
    public String removeDigit(String number, char digit){
        List<Integer> l = new ArrayList<>();
        StringBuffer sb = new StringBuffer(number);

        for(int i=0; i<number.length(); i++){
            if(number.charAt(i)==digit) l.add(i);
        }
        
        for(int i:l){
            if(i<number.length()-1){
                char a = number.charAt(i), b = number.charAt(i+1);
                if(a==digit && Character.getNumericValue(a)<Character.getNumericValue(b)){
                    sb.deleteCharAt(i);
                    return sb.toString();
                }
            }
        }

        sb.deleteCharAt(l.get(l.size()-1));
        return sb.toString();
    }
}
