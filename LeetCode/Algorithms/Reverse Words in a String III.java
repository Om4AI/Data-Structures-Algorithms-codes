class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        for (int i=0; i<arr.length; i++){
            arr[i] = rev_str(arr[i].toCharArray());
        }
        StringBuffer sb = new StringBuffer();
        int i =0;
        while(i<arr.length-1){
            sb.append(arr[i]);
            sb.append(" ");
            i++;
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();
    }
    
    public static String rev_str(char[] s){
        int i=0, j=s.length-1;
        while(i<j){
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
        return String.valueOf(s);
    }
}
