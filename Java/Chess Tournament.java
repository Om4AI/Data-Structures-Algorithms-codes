import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), k = s.nextInt();
        List<Integer> rat = new ArrayList<Integer>();
        for (int i=0; i<n; i++){rat.add(s.nextInt());}
        int wins = 0, winner, loser;
        // First winner
        winner = (rat.get(0) > rat.get(1)? rat.get(0): rat.get(1));
        // First losser send later
        loser = (rat.get(0)<rat.get(1)? rat.get(0): rat.get(1));
        rat.remove(rat.indexOf(loser));
        rat.add(loser);
        wins+=1;
        while (wins<k){
            int el = (rat.get(0) > rat.get(1)? rat.get(0): rat.get(1));
            loser = (rat.get(0)<rat.get(1)? rat.get(0): rat.get(1));
            // Winner condition
            if (winner == el){
                wins += 1;
                rat.remove(rat.indexOf(loser));
                rat.add(loser);
            }
            else if (winner != el){
                winner = el;
                wins = 1;
                rat.remove(rat.indexOf(loser));
                rat.add(loser);
            }
        }
        System.out.println(winner);
    }
}
