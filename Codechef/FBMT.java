import java.util.*;

class CodeChef{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            if (n==0){
                System.out.println("Draw");
                continue;
            }
            String goals[] = new String[n];
            for (int i=0; i<n; i++)goals[i] = s.next();

            int t1_score = 0;
            int t2_score = 0;
            String team1 = goals[0];
            String team2 = "";

            for (int i=0; i<n; i++){
                if(goals[i].equals(team1)){
                    t1_score++;
                }else{
                    team2 = goals[i];
                    t2_score++;
                }
            }
            if (t1_score>t2_score){
                System.out.println(team1);
            }else if (t2_score>t1_score){
                System.out.println(team2);
            }else System.out.println("Draw");
        }
        s.close();
    }
}