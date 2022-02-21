class Solution {
    public int minimumSum(int num) {
        List<Integer> l = new ArrayList<>();
        String s = String.valueOf(num);
        for(int i=0; i<s.length(); i++){
            l.add(Character.getNumericValue(s.charAt(i)));
        }
        Collections.sort(l);
        int res = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(l.get(0)));
        sb.append(String.valueOf(l.get(3)));
        res+=Integer.parseInt(sb.toString());
        sb.setLength(0);
        sb.append(String.valueOf(l.get(1)));
        sb.append(String.valueOf(l.get(2)));
        res+=Integer.parseInt(sb.toString());
        return res;
    }
}
