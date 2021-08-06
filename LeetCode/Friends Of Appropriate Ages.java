// Code by @Om

class Solution {
    public int numFriendRequests(int[] ages) {
        
        int agecounts[] = new int[121];  //Range goes from 0-120 (Age range)
        int freqs = 0;
        
//         Calculate the number of people for each age
//         Essentially each index is the count of people for that age
        for (int age: ages){
            agecounts[age]++;
        }
        
//         Get the no. of friend requests
        for (int a=0; a<121; a++){
//             Range of b's age --> ((0.5*a+7)-a)
            for (int b= (int)(0.5*a+7+1); b<=a; b++){
//                 Count of friend requests
                freqs += agecounts[a] * agecounts[b];  // a & b are ages
                
                if (a==b){
//                     Reduce the requests made to himself/herself
                    freqs -= agecounts[a];
                }
            }
        }
        return freqs;
    }
}
