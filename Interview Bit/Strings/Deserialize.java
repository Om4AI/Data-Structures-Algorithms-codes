
// -------------------Interview Bit Format-------------------------
import java.util.*;
public class Solution {
    public static ArrayList<String> deserialize(String s){
        ArrayList<String> res = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        int added = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!='~' && Character.isLetter(c)){
                sb.append(c);
            }else if(Character.isDigit(c) && added==0){
                res.add(sb.toString());
                added = 1;
            }else if (c=='~'){
                sb.setLength(0);
                added =0;
            }
        }

        return res;
    }
}



// --------------------Local testing format----------------------------
public class Deserialize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.println(deserialize(a));
    }

    public static ArrayList<String> deserialize(String s){
        ArrayList<String> res = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        int added = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!='~' && Character.isLetter(c)){
                sb.append(c);
            }else if(Character.isDigit(c) && added==0){
                res.add(sb.toString());
                added = 1;
            }else if (c=='~'){
                sb.setLength(0);
                added =0;
            }
        }

        return res;
    }
}
