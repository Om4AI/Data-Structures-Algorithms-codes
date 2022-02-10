import java.util.*;
int MCM(int arr[], int i, int j){
    // Base Condition - 1 element case is also invalid
    if(i>=j) return 0;
    
    // K scheme and FOR loop
    int min = Integer.MAX_VALUE;
    for(int k=i; k<=j-1; k++){
        int temp = MCM(arr, i, k) + MCM(arr, k+1, j) + (arr[i-1]*arr[k]*arr[j]);

        min = Math.min(min, temp);
    }
    return min;
}