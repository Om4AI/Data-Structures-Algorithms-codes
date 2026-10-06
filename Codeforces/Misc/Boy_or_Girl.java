import java.util.*;
public class Boy_or_Girl {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        HashSet<Character> set = new HashSet<Character>();
        for(char c:a.toCharArray()) set.add(c);

        if(set.size()%2!=0) System.out.println("IGNORE HIM!");
        else System.out.println("CHAT WITH HER!");
    }
}
