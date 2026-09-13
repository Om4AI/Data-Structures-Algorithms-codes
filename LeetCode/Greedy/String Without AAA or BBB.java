class Solution {
    public String strWithout3a3b(int a, int b){

        // Assign turn
        int turn = (a>=b)? 1: 2;
        StringBuffer sb = new StringBuffer();

        // Actual loop
        while(a>0 && b>0){
            if(a==b){
                return equalStringConstruct(sb,a,turn);
            }
            else if(turn==1){
                if(a>=b){
                    sb.append("aa");
                    a-=2;
                    turn = 2;
                }else{
                    sb.append("a");
                    a-=1;
                    turn = 2;
                }
            }else{
                if(b>=a){
                    sb.append("bb");
                    b-=2;
                    turn = 1;
                }else{
                    sb.append("b");
                    b-=1;
                    turn = 1;
                }
            }
        }

        // Remaining occurences of a/b
        if(a!=0){
            while(a!=0){
                sb.append("a");
                a--;
            }
        }else if(b!=0){
            while(b!=0){
                sb.append("b");
                b--;
            }
        }
        
        return sb.toString();
    }

    public static String equalStringConstruct(StringBuffer sb, int a, int turn){
        while(a-->0){
            if(turn==1) sb.append("ab");
            else sb.append("ba");
        }
        return sb.toString();
    }
}