class Solution {
    static int getnum(char c){
        int r=0;
        switch (c){
            case ('I'):
               r= 1;
               break;
            case ('V'):
               r= 5;
               break;
            case ('X'):
               r=  10;
               break;
            case ('L'):
               r=50;
               break;
            case ('C'):
               r=100;
               break;
            case ('D'):
               r=500;
               break;
            case ('M'):
               r=1000;
               break;
        }
        return r;
    }
    public int romanToInt(String s) {
        char c[] = new char[s.length()];
        for (int i=0;i<s.length();i++){
            c[i] = s.charAt(i);
        }
        int result = 0, f=0;
        for (int i=0;i<c.length-1;i++){
            if (getnum(c[i])<getnum(c[i+1])){
                result += getnum(c[i+1]) - getnum(c[i]);
                if (i==c.length-2){f=1;}
                i+=1;
            }
            else{
                result += getnum(c[i]);
            }
        }
        if (f==0){return (result+getnum(c[c.length-1]));}
        else{return result;} 
    }
}
