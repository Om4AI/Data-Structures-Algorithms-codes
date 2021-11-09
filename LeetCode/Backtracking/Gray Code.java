class Solution {
    public List<Integer> grayCode(int n){
        List<String> pres = graycode(n);

        // Convert to numbers & return numeric result
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<pres.size(); i++){
            res.add(binary_to_nums(pres.get(i)));
        }
        return res;
    }

    public List<String> graycode(int n){
        if(n==1){
            List<String> l = new ArrayList<>();
            l.add("0");
            l.add("1");
            return l;
        }

        // Get previous list of graycodes
        List<String> l = graycode(n-1);
        List<String> lnew = new ArrayList<>();
        for (int i=0; i<l.size(); i++) lnew.add("0"+l.get(i));
        for (int i=l.size()-1; i>=0; i--) lnew.add("1"+l.get(i));
        return lnew;
    }

    public int binary_to_nums(String s){
        // Conversion
        int num=0, c=0;
        for (int i=s.length()-1; i>=0; i--){
            int cin = Character.getNumericValue(s.charAt(i));
            num+=cin*Math.pow(2,c);
            c++;
        }
        return num;
    }
}
