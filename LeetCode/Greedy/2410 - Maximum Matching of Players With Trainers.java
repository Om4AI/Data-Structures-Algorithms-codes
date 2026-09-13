// Sort the arrays to fulfill the training requirement
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers){
        Arrays.sort(trainers);
        Arrays.sort(players);

        int tp=0, pp = 0, count = 0;
        while (tp<trainers.length && pp<players.length){
            if (trainers[tp]>=players[pp]){
                count++;
                tp++;
                pp++;
            }else if (trainers[tp]<players[pp]) tp++;
        }
        return count;
    }
}