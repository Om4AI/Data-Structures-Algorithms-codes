class Solution {
    public int scoreOfParentheses(String s){
        int n = s.length();
        Stack<String> stk = new Stack<>();

        for(int i=0; i<n; i++){
            String str = String.valueOf(s.charAt(i));
            
            if(str.equals("(")) stk.push(str);
            else if (str.equals(")")){
                String temp = stk.peek();
                if(temp.equals("(")){
                    stk.pop();
                    stk.push("1");
                }else if(isNumeric(temp)){
                    int sum = 0;
                    while(!stk.isEmpty() && isNumeric(stk.peek()) && !stk.peek().equals("(")){
                        sum += Integer.parseInt(stk.pop());
                    }
                    if(stk.peek().equals("(")){
                        stk.pop();
                        stk.push(String.valueOf(sum*2));
                    }
                }
            }
        }
        if(stk.size()>1){
            int t = 0;
            while(!stk.isEmpty()){t+=Integer.parseInt(stk.pop());}
            return t;
        }
        return Integer.parseInt(stk.pop());
    }

    public static boolean isNumeric(String s){
        try{
            int n = Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}