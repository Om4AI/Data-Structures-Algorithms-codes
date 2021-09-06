import java.util.*;
class Solution {
    public char slowestKey(int[] rt, String keysPressed) {
        int n = rt.length, max = rt[0];
        int arr[] = new int[n];
        arr[0] = rt[0];
        for (int i=1; i<n; i++){
            arr[i] = rt[i] - rt[i-1];
            if (arr[i]>max){
                max = arr[i];
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (arr[i]==max){
                list.add(keysPressed.charAt(i));
            }
        }
        if (list.size()>1){
            Collections.sort(list);
        }
        return list.get(list.size()-1);
    }
}
