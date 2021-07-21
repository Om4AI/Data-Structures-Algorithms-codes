class Solution {
    public String pushDominoes(String d) {
        int rdist[] = new int[d.length()];
        int ldist[] = new int[d.length()];
//         Check for right falling dominoes
        for (int i=0; i<d.length(); i++){
            if (d.charAt(i)=='R'){
                rdist[i] = 0;
                i++;
//                 Iterate till we get a L
                int dist = 1;
                while (i<d.length() && d.charAt(i)!='L'){
                    if (d.charAt(i)=='R'){
                        rdist[i] = 0;
                        dist = 1;
                        i++;
                    }
                    else{
                        rdist[i] = dist;
                        // System.out.println(d.charAt(i));
                        dist++;
                        i++;
                    }
                    
                }
            }
            else{
                rdist[i] = 0;
            }
        }
//         Print the right pass array
        for (int i=0; i<rdist.length; i++){System.out.print(rdist[i]+" ");}
        
//         Check for left falling dominoes
        for (int i=d.length()-1; i>-1; i--){
            if (d.charAt(i)=='L'){
                ldist[i] = 0;
                i--;
//                 Iterate till we get a R
                int dist = 1;
                while (i>-1 && d.charAt(i)!='R'){
                    if (d.charAt(i)=='L'){
                        ldist[i] = 0;
                        dist = 1;
                        i--;
                    }
                    else{
                        ldist[i] = dist;
                        // System.out.println(d.charAt(i));
                        dist++;
                        i--;
                    }
                    
                }
            }
            else{
                ldist[i] = 0;
            }
        }
//         Logic for dominoes
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<d.length(); i++){
//             Case 1
            if (rdist[i]==0 && ldist[i]==0){sb.append(d.charAt(i));}
            else if (rdist[i]==ldist[i]){sb.append('.');}
            else if (rdist[i]==0 && ldist[i]!=0){sb.append('L');}
            else if (rdist[i]!=0 && ldist[i]==0){sb.append('R');}
            else if (rdist[i]<ldist[i]){sb.append('R');}
            else{sb.append('L');}
        }
        return sb.toString();
    }
}
