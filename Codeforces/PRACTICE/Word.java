import java.util.*;
public class Word{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();

        int lc = 0, uc = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int ascii = (int)c;
            if(ascii>=97 && ascii<=122) lc++;
            else uc++;
        }
        
        if(lc>=uc)System.out.println(str.toLowerCase());
        else System.out.println(str.toUpperCase()); 
    }
}