import java.util.*;

class Solution {
    public ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> fullJustify(ArrayList<String> A, int maxw) {
        if(A.size()<1) return res;
        String[] arr = new String[A.size()];
        for (int i=0; i<A.size(); i++){
            arr[i] = A.get(i);
        }
        // Start traversing the array

        int count = 0, letters_count=0, is_start=1;
        int start=0, end = 0;
        while(end<arr.length){
            String s = arr[end];
            
            if(is_start==1){
                count+=s.length();
                is_start=0;
            }
            else count=count+1+s.length();

            // Check after adding the word; whether it exceeds max width
            if(count<=maxw){
                end+=1;

                // Count the letters from the words
                letters_count+=s.length();

            }else{
                // PROCESS
                generateString(arr,start,end,maxw,end-start,letters_count);

                is_start = 1;
                count=0;
                letters_count=0;
                start=end;
            }
        }
        generateLastString(arr,start,end,maxw,end-start,letters_count);
        return res;
    }



    public void generateString(String[] arr,int start,int end, int max_width,int no_words,int letters_count){
        // Case - Only 1 word
        if(no_words>1){
            int[] spaces = calculateSpaces(max_width,letters_count,no_words-1);

            // Create the string
            StringBuffer sb = new StringBuffer();
            int sc = 0;
            for (int i=start; i<end; i++){
                sb.append(arr[i]);
                if(sc<spaces.length){
                    while(spaces[sc]-->0)sb.append(" ");
                }
                sc++;
            }
            res.add(sb.toString());
        }
        else if(no_words==1){
            int spaces = max_width-letters_count;
            StringBuffer sb = new StringBuffer();
            sb.append(arr[start]);
            while(spaces-->0){
                sb.append(" ");
            }
            // sb.append(" ".repeat(spaces));
            res.add(sb.toString());
        }
    }

    public int[] calculateSpaces(int max_width, int letters_count, int no_places){
        int spaces = max_width-letters_count;
        int[] spaces_count = new int[no_places];

        int i=0;
        while(spaces>0){
            spaces_count[i%no_places]+=1;
            spaces--;
            i++;
        }
        return spaces_count;
    }

    public void generateLastString(String[] arr,int start,int end, int max_width,int no_words,int letters_count){
        int spaces = max_width-letters_count;
        StringBuffer sb = new StringBuffer();
        // Only 1 word case
        if(no_words==1){
            sb.append(arr[start]);
            while(spaces-->0){
                sb.append(" ");
            }
            res.add(sb.toString());
        }else{
            for (int i=start; i<end; i++){
                sb.append(arr[i]);
                if(spaces>0)sb.append(" ");
                spaces--;
            }
            if(spaces>0){
                while(spaces-->0){
                sb.append(" ");
            }
            }
            res.add(sb.toString());
        }
    }
}
