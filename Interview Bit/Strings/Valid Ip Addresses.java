import java.util.*;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s){
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();

        for (int i=1; i<=n-3; i++){
            for (int j=i+1; j<=n-2; j++){
                for (int k=j+1; k<=n-1; k++){
                    String segA = s.substring(0, i);
                    String segB = s.substring(i, j);
                    String segC = s.substring(j, k);
                    String segD = s.substring(k, n);

                    if (in_ip_range(segA) && in_ip_range(segB) && in_ip_range(segC) && in_ip_range(segD)){
                        StringBuffer sb = new StringBuffer();
                        sb.append(segA);
                        sb.append(String.valueOf('.'));
                        sb.append(segB);
                        sb.append(String.valueOf('.'));
                        sb.append(segC);
                        sb.append(String.valueOf('.'));
                        sb.append(segD);

                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }

    public static boolean in_ip_range(String s){
        // Edge case of 0x
        if (s.length()>1 && s.charAt(0)=='0') return false;

        int ip_seg = Integer.parseInt(s);
        return (ip_seg>=0 && ip_seg<=255)? true: false;
    }
}
