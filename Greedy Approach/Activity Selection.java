class Times{
    int start, end;

    Times(int s, int e){
        start = s;
        end = e;
    }
}


class Solution{
    public static int activitySelection(int start[], int end[], int n){
        // Sort according to end times
        int c=1;

        sortArrays(start,end,n);

        // Count the number of activities
        int recent_end = end[0];
        for(int i=1; i<n; i++){
            if(start[i]>recent_end){
                c++;
                recent_end = end[i];
            }
        }
        return c;
    }



    public static void sortArrays(int[] start, int[] end, int n){
        Times[] arr = new Times[n];

        // Fill array with objects
        for(int i=0; i<n; i++){
            Times obj = new Times(start[i],end[i]);
            arr[i] = obj;
        }

        // Sort times array
        Arrays.sort(arr,(a,b)->(a.end-b.end));
        for(int i=0; i<n; i++){
            start[i] = arr[i].start;
            end[i] = arr[i].end;
        }
    }
}