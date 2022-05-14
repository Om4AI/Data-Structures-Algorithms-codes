public class Solution {
    String max;
    public String solve(String s, int swaps){
        max = s;
        inner_solve(s, swaps, 0);
        return max;
    }

    public void inner_solve(String s,int k, int p){
        if (k==0) return ;

        int n = s.length();
        char maxc = s.charAt(p);

        // Get maximum character
        for (int i=p+1; i<n; i++){
            if (s.charAt(i)>maxc){
                maxc = s.charAt(i);
            }
        }
        // Max char found

        if (maxc!=s.charAt(p))k--;

        for (int i=p; i<n; i++){
            if (s.charAt(i)==maxc){
                char arr[] = s.toCharArray();
                char temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
                String swapped = new String(arr);
                if (swapped.compareTo(max)>0) max = swapped;
                inner_solve(swapped, k, p+1);
            }
        }
    }
}
