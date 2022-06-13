import java.util.*;

class Times{
    int start, end;

    Times(int s, int e){
        start = s;
        end = e;
    }
}


public class Sort_2_Arrays {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = s.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        // Accept start and end times
        for(int i=0; i<n; i++){
            start[i] = s.nextInt();
            end[i] = s.nextInt();
        }

        sortArrays(start,end,n);

        // Print arrays
        System.out.println("Sorted times: ");
        for(int i=0; i<n; i++){
            System.out.print(start[i]+" ");
        }
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.print(end[i]+" ");
        }
    }

    public static void sortArrays(int[] start, int[] end, int n){
        Times[] arr = new Times[n];
        
        // Fill the times array with values
        for(int i=0; i<n; i++){
            Times obj = new Times(start[i], end[i]);
            arr[i] = obj;
        }

        // Sort the Times[] object array
        Arrays.sort(arr,(a,b)->(a.end-b.end));

        for(int i=0; i<n; i++){
            start[i] = arr[i].start;
            end[i] = arr[i].end;
        }
    }
}
