import java.util.*;
class Solution {
    public String validIPAddress(String s){

        if(s==null || s.length()==0 || s.charAt(s.length()-1)=='.' || s.charAt(s.length()-1)==':') return "Neither";
        // Split up the string into divisions
        String[] div1 = s.split("\\."); //IPv4
        String[] div2 = s.split(":");   //IPv6

        if(div1.length > div2.length){
            if(isIPv4(div1)) return "IPv4";
        }
        if(div2.length > div1.length){
            if(isIPv6(div2)) return "IPv6";
        }
        return "Neither";
    }
    
    // Check for IPv4
    public boolean isIPv4(String[] arr){
        if(arr.length!=4) return false;

        // Check leading zeros
        for (int i=0; i<arr.length; i++)
            if(arr[i].length()>1 && arr[i].charAt(0)=='0') return false;

        // Check for number range
        for (int i=0; i<arr.length; i++){
            int num = -1;
            try{
                num = Integer.parseInt(arr[i]);
            }catch(Exception e){return false;}
            if(!(num>=0) || !(num<=255)) return false;
        }  
        return true;
    }

    // Check IPv6
    public boolean isIPv6(String[] arr){
        if(arr.length!=8) return false;

        // Check length of each section
        for (int i=0; i<arr.length; i++){
            int len = arr[i].length();
            if(!(len>=1 && len<=4)) return false;
        }

        // Check the characters in each section
        for (int i=0; i<arr.length; i++){
            // Inside each string
            for (int j=0; j<arr[i].length(); j++){
                // Each character inside each string
                char c = arr[i].charAt(j);
                if(Character.isLetter(c)){
                    // Check if its between a-f or A-F
                    int ascii = (int)c;
                    if(!(ascii>=97 && ascii<=102) && !(ascii>=65 && ascii<=70)) return false;
                }
            }
        }
        return true;
    }
}