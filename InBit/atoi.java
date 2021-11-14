class Solution {
    public int myAtoi(String s) {
//         Base Case
        if(s.length()==0) return 0;
        
        List<Character> nums = new ArrayList<>();
        int res = 0, i=0;
        char fc = '+';
        StringBuffer sb = new StringBuffer();
        for (char c='0'; c<='9'; c++) nums.add(c);

        // Point 1
        s = s.trim();
        if(s.length()==0) return 0;
        
        // Point 2 - Middle main IMP part
        if(!nums.contains(s.charAt(0)) && (s.charAt(0)=='-' || s.charAt(0)=='+')){
            fc = s.charAt(0);
            i = 1;
        }

        while(i<s.length() && nums.contains(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }

        if(sb.length()==0) return 0;
        else sb.insert(0, fc);
        
        // Point 5 - Final Answer
        try{
            res = Integer.parseInt(sb.toString());
        }catch (Exception e){
            if(sb.toString().charAt(0)=='-') res= -2147483648;
            else res= 2147483647;
        }
        return res;
    }
}
