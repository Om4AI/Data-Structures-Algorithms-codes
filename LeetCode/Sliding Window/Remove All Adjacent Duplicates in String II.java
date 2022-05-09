// Sliding Window Approach (TLE)
import java.util.*;

class Solution {
    static int f = 0;
    public String removeDuplicates(String s, int k) {
        while(true){
            f = 0;
            s = removeRepeated(s,k);
            if(f==1){
                continue;
            }else if(f==0){
                return s;
            }
        }

    }

    public static String removeRepeated(String s,int k){
        
        // Base Case
        if(s.length()<k) return s;

        // Step 1: Initial Sliding Window count - K size
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);

        // Step 2: Actual Loop
        int i=0, j = k-1;
        StringBuffer sb = new StringBuffer();
        while(j<s.length()-1){
            
            // CASE 1: No removal
            if(j<s.length() && map.size()>1){
                Character ichar = s.charAt(i);
                sb.append(ichar);
                map.put(ichar, map.get(ichar)-1);
                if(map.get(ichar)==0) map.remove(ichar);
                
                
                i++;
                j++;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            }
            
            // CASE 2: Remove
            else if (map.size()==1){
                f = 1;
                int p =1;
                if((j+k)>s.length()-1){
                    i+=k;
                    for(int m=i; m<=s.length()-1; m++){
                        sb.append(s.charAt(m));
                    }
                    return sb.toString();
                }

                
                while(j<s.length()-1 && p<=k){
                    // Shift
                    Character ichar = s.charAt(i);
                    map.put(ichar, map.get(ichar)-1);
                    if(map.get(ichar)==0) map.remove(ichar);
                    
                    i++;
                    j++;
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                    p++;
                }
            }
        }

        if(map.size()>1){
            // for(int m=i; m<=j; m++){
            //     sb.append(s.charAt(m));
            // }
            sb.append(s.substring(i,j));
        }
        return sb.toString();
    }
}



// Stack Approach (TLE)
import java.util.*;

class Solution {
    static int f=0;
    public String removeDuplicates(String s, int k) {
        while(true){
            f = 0;
            s = removeRepeated(s,k);
            if(f==1){
                continue;
            }else if(f==0){
                return s;
            }
        } 
    }

    public static String removeRepeated(String s, int k){
        Stack<Character> stk = new Stack<>();
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stk.isEmpty()){
                stk.push(c);
                continue;
            }
            
            // Stack full
            if(stk.size()==k){
                f = 1;
                stk = new Stack<>();
                stk.push(c);
            }

            // Stack Not full
            else if(stk.size()<k){
                if(c==stk.peek())stk.push(c);
                else{
                    while(!stk.isEmpty()){
                        sb.append(stk.pop());
                    }
                    stk.push(c);
                }
            }
        }
        // Last check
        if(stk.size()<k){
            while(!stk.isEmpty()){sb.append(stk.pop());}
        }
        return sb.toString();
    }
}
