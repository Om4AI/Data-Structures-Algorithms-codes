class Solution {
    public boolean squareIsWhite(String c) {
        boolean result = true;;
        if (c.charAt(0)=='a'||c.charAt(0)=='c'||c.charAt(0)=='e'||c.charAt(0)=='g'){
            if ((c.charAt(1)=='1'||c.charAt(1)=='3'||c.charAt(1)=='5'||c.charAt(1)=='7')){
                result = false;
            }
            else{result= true;}
        }
        else if (c.charAt(0)=='b'||c.charAt(0)=='d'||c.charAt(0)=='f'||c.charAt(0)=='h'){
            if ((c.charAt(1)=='2'||c.charAt(1)=='4'||c.charAt(1)=='6'||c.charAt(1)=='8')){
                result = false;
            }
            else{result= true;}
        }
        return result;
    }
}
