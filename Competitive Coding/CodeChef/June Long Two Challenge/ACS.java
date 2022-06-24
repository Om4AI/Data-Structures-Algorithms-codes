import java.util.*;

class ACS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-->0){
            int score = s.nextInt();
            int probs = score/100;
            if(score%100 > (10-probs)){
                System.out.println(-1);
                continue;
            }else{
                probs += score%100;
            }
            System.out.println(probs);
        }
    }   
}
