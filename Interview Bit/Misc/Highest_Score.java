
// -----------------------Interview Bit Format solution------------------------
import java.util.*;
public class Solution {
    public static int highestScore(String[][] arr){
        HashMap<String, Integer> values_map = new HashMap<>();
        HashMap<String, Integer> count_map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            String name = arr[i][0];
            int marks = Integer.parseInt(arr[i][1]);
            values_map.put(name, values_map.getOrDefault(name, 0)+marks);
            count_map.put(name, count_map.getOrDefault(name, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(String k: values_map.keySet()){
            int avg = (int)Math.floor(values_map.get(k)/count_map.get(k));
            max = Math.max(max, avg); 
        }
        return max;
    }
}




// ------------------Local Test Solution---------------------------
public class Highest_Score {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[][] arr= new String[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = s.next();
            arr[i][1] = s.next();
        }

        System.out.println(highestScore(arr)); 
    }

    public static int highestScore(String[][] arr){
        HashMap<String, Integer> values_map = new HashMap<>();
        HashMap<String, Integer> count_map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            String name = arr[i][0];
            int marks = Integer.parseInt(arr[i][1]);
            values_map.put(name, values_map.getOrDefault(name, 0)+marks);
            count_map.put(name, count_map.getOrDefault(name, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(String k: values_map.keySet()){
            int avg = (int)Math.floor(values_map.get(k)/count_map.get(k));
            max = Math.max(max, avg); 
        }
        return max;
    }
}
