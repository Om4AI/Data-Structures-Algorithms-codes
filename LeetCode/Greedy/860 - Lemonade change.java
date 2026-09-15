// Initial solution with Array to keep track of note counts
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Note count contains the number of notes we have of each denomination (5,10,15) resp
        int[] noteCount = new int[3];
        for (int i=0; i<bills.length; i++){
            // 3 cases - 5 (no change returned) | 10 (5 returned)
            // 20 (10+5 or 5+5+5 returned)
            if (bills[i]==5){
                noteCount[0]++;
            }else if (bills[i]==10){
                if (noteCount[0]<1) return false;
                else{
                    noteCount[0]--;
                    noteCount[1]++;
                }
            }else if (bills[i]==20){
                if (noteCount[1]>=1 && noteCount[0]>=1){
                    noteCount[1]--;
                    noteCount[0]--;
                }else if  (noteCount[0]>=3){
                    noteCount[0]-=3;
                }
                else return false;
            }
        }
        return true;
    }
}


// Memory optimization - Array removed
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Note count contains the number of notes we have of each denomination (5,10,15) resp
        int fives=0, tens=0;
        for (int i=0; i<bills.length; i++){
            // 3 cases - 5 (no change returned) | 10 (5 returned)
            // 20 (10+5 or 5+5+5 returned)
            if (bills[i]==5){
                fives++;
            }else if (bills[i]==10){
                if (fives<1) return false;
                else{
                    fives--;
                    tens++;
                }
            }else if (bills[i]==20){
                if (tens>=1 && fives>=1){
                    tens--;
                    fives--;
                }else if  (fives>=3){
                    fives-=3;
                }
                else return false;
            }
        }
        return true;
    }
}