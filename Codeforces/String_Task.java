import java.util.*;
public class String_Task {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        StringBuffer sb = new StringBuffer();
        for (char c: str.toCharArray()){
            if (!is_vowel(c)){
                sb.append(".");
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean is_vowel(char c){
        c = Character.toLowerCase(c);
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y') return true;
        else return false;
    }
}
