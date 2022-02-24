public class Solution {
    public static int mod = 1003;
    public int cnttrue(String s){
        int n = s.length();
        int i=0, j = n-1;
        HashMap<String, Integer> map = new HashMap<>();
        return eval_exp_true(i,j,s,true,map);
    }

    public static int eval_exp_true(int i,int j,String s,boolean flag,HashMap<String, Integer> map){
        // Base condition
        if(i>j) return 0;
        // Single character
        if(i==j){
            if(flag==true){
                return (s.charAt(i)=='T')?1:0;
            }else{
                return (s.charAt(i)=='F')?1:0;
            }
        }

        // Memoization check
        StringBuffer sb = new StringBuffer(Integer.toString(i));
        sb.append(" ");
        sb.append(Integer.toString(j));
        sb.append(" ");
        sb.append(Boolean.toString(flag));
        String temp = sb.toString();

        if(map.containsKey(temp)) return map.get(temp);

        // Actual k scheme
        int ans =0;
        for(int k=i+1; k<=j-1; k+=2){
            int LT = eval_exp_true(i,k-1,s,true,map);
            int LF = eval_exp_true(i,k-1,s,false,map);
            int RT = eval_exp_true(k+1,j,s,true,map);
            int RF = eval_exp_true(k+1,j,s,false,map);

            // Conditons based on operation
            char op = s.charAt(k);
            if(op=='&'){
                if(flag==true) ans = ans+(LT*RT)%mod;
                else ans = ans+(LT*RF)%mod+(LF*RT)%mod+(LF*RF)%mod;
            }else if(op=='|'){
                if(flag==true) ans = ans+(LT*RF)%mod+(LF*RT)%mod+(LT*RT)%mod;
                else ans = ans+(LF*RF)%mod;
            }else if(op=='^'){
                if(flag==true) ans = ans+(LT*RF)%mod+(LF*RT)%mod;
                else ans = ans+(LF*RF)%mod+(LT*RT)%mod;
            }
        }

        map.put(temp, ans%mod);
        return map.get(temp);
    }
}
