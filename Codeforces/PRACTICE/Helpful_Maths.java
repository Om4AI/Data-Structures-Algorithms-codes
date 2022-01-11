import java.util.*;
public class Helpful_Maths {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = s.next();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) !='+'){
                list.add(Character.getNumericValue(str.charAt(i)));
            }
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for(int i:list){
            sb.append(i);
            sb.append("+");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
