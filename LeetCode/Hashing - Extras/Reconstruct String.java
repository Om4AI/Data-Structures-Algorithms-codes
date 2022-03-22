import java.util.*;

class Solution {
    public String originalDigits(String s){
        // zero - z hai to 0 hai
        // one - 2nd iteration (o)
        // two - w hai toh 2 hai
        // three - 2nd iteration (t)
        // four - u hai toh 4 hai
        // five - 2nd iteration (f)
        // six - x hai toh 6 hai
        // seven - 2nd iteration - (s)
        // eight - g hai toh 8 hai
        // nine - 2nd iteration (Count letters)
        
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        List<Integer> l = new ArrayList<>();
        
        // Create occurences map
        for(int i=0; i<n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        
        // Iteration 1
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c=='z'){
                map.put('z',map.get('z')-1);
                map.put('e',map.get('e')-1);
                map.put('r',map.get('r')-1);
                map.put('o',map.get('o')-1);
                l.add(0);
            }else if(c=='w'){
                map.put('t',map.get('t')-1);
                map.put('w',map.get('w')-1);
                map.put('o',map.get('o')-1);
                l.add(2);
            }else if(c=='u'){
                map.put('f',map.get('f')-1);
                map.put('o',map.get('o')-1);
                map.put('u',map.get('u')-1);
                map.put('r',map.get('r')-1);
                l.add(4);
            }else if (c=='x'){
                map.put('s',map.get('s')-1);
                map.put('i',map.get('i')-1);
                map.put('x',map.get('x')-1);
                l.add(6);
            }else if(c=='g'){
                map.put('e',map.get('e')-1);
                map.put('i',map.get('i')-1);
                map.put('g',map.get('g')-1);
                map.put('h',map.get('h')-1);
                map.put('t',map.get('t')-1);
                l.add(8);
            }
        }
        s = construct_string(map);
        
        // Iteration 2
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='o'){
                map.put(c,map.get(c)-1);
                map.put('n',map.get('n')-1);
                map.put('e',map.get('e')-1);
                l.add(1);
            }else if(c=='t'){
                map.put(c,map.get(c)-1);
                map.put('h',map.get('h')-1);
                map.put('r',map.get('r')-1);
                map.put('e',map.get('e')-2);
                l.add(3);
            }else if(c=='f'){
                map.put(c,map.get(c)-1);
                map.put('i',map.get('i')-1);
                map.put('v',map.get('v')-1);
                map.put('e',map.get('e')-1);
                l.add(5);
            }else if(c=='s'){
                map.put(c,map.get(c)-1);
                map.put('e',map.get('e')-2);
                map.put('v',map.get('v')-1);
                map.put('n',map.get('n')-1);
                l.add(7);
            }
        }
        int sum = 0;
        for(char k:map.keySet()){
            sum+=map.get(k);
        }
        int inst_nine = sum/4;
        while(inst_nine-->0){
            l.add(9);
        }
        
        Collections.sort(l);
        StringBuffer sb = new StringBuffer();
        for(int i:l){
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    public static String construct_string(HashMap<Character, Integer> map){
        StringBuffer sb = new StringBuffer();
        for(char k:map.keySet()){
            sb.append(Collections.nCopies(map.get(k),k));
        }
        return sb.toString();
    }
}