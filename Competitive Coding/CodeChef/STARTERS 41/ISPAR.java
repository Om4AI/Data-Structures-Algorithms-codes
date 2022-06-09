import java.util.*;
public class ISPAR {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-->0){
            String n = s.next();
            String k = s.next();

            // Case of 1
            if(k.equals("1")){
                if(isEven(n)) System.out.println("EVEN");
                else System.out.println("ODD");
            }

            // Case of 2
            else if(k.equals("2")) System.out.println("ODD");

            // Other cases
            else System.out.println("EVEN");
        }
    }

    public static boolean isEven(String s){
        int unit = Character.getNumericValue(s.charAt(s.length()-1));

        return unit%2==0;
    }
}
