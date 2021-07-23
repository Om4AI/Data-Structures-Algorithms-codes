import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<String, Integer> par = new HashMap<>();
        int max_score = 0;
        String max_name = "";
        for (int i=0; i<n; i++){
            String name = s.next();
            int score = s.nextInt();
            if (par.containsKey(name)){
                par.replace(name, par.get(name)+score);
            }
            else{
                par.put(name, score);
            }
            int new_max_score = Collections.max(par.values());
            if (new_max_score>max_score){
                max_name = name;
                max_score = new_max_score;
            }
        }
        System.out.println(max_name);
    }
}
