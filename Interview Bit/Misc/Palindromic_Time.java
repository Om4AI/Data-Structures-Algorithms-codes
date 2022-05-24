// Interview Bit Format solution
import java.util.*;
public class Solution {
    public int solve(String time){
        int c = 0;
        
        int hrs = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(3,5));
        
        while(!isTimePalindromic(hrs,mins)){
            mins++;
            c++;

            // Conditions for minutes
            if(mins==60){
                mins=0;
                hrs++;
                
                // Check hours condition
                if(hrs==24){
                    hrs = 0;
                }
            }
        }
        return c;
    }

    public static boolean isTimePalindromic(int hrs, int mins){
        String hr="", min="";
        hr = (hrs<10) ? new StringBuffer("0").append(String.valueOf(hrs)).toString() : String.valueOf(hrs);
        min = (mins<10) ? new StringBuffer("0").append(String.valueOf(mins)).toString() : String.valueOf(mins);
        
        if((hr.charAt(0)==min.charAt(1)) && (hr.charAt(1)==min.charAt(0))) return true;
        return false;
    }
}


// ------------------------- Local Checking Code (Along with I/O operations) ------------------------
// public class Palindromic_Time {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         String time = s.next();
//         int c = 0;
        
//         int hrs = Integer.parseInt(time.substring(0,2));
//         int mins = Integer.parseInt(time.substring(3,5));
        
//         while(!isTimePalindromic(hrs,mins)){
//             mins++;
//             c++;

//             // Conditions for minutes
//             if(mins==60){
//                 mins=0;
//                 hrs++;
                
//                 // Check hours condition
//                 if(hrs==24){
//                     hrs = 0;
//                 }
//             }
//         }
//         System.out.println("Minimum minutes: "+c);
//     }

//     public static boolean isTimePalindromic(int hrs, int mins){
//         String hr="", min="";
//         hr = (hrs<10) ? new StringBuffer("0").append(String.valueOf(hrs)).toString() : String.valueOf(hrs);
//         min = (mins<10) ? new StringBuffer("0").append(String.valueOf(mins)).toString() : String.valueOf(mins);
        
//         if((hr.charAt(0)==min.charAt(1)) && (hr.charAt(1)==min.charAt(0))) return true;
//         return false;
//     }
// }


