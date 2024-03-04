import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Sort and initialize
        Arrays.sort(tokens);
        int score = 0, fup = 0, fdown = tokens.length-1;

        while (fup<=fdown && ((power>=tokens[fup]) || (score>=1))){
            // Greedy logic
            // Edge case - Avoid losing score on the last step
            if (fup==fdown){
                if (power>=tokens[fup]){
                    power-=tokens[fup];
                    score++;
                    fup++;
                }
                break;
            }

            // General case - Try faceup approach first
            else if (power>=tokens[fup]){
                power-=tokens[fup];
                score++;
                fup++;
            }else if (score>=1){ // Face down approach - Gain power
                score--;
                power+=tokens[fdown];
                fdown--;
            }
        }
        return score;
    }
}