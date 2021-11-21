class Solution { 


    public String addBinary(String a1, String b1){
        int n1 = a1.length();
        int n2 = b1.length();
        StringBuffer res = new StringBuffer();
        int c = 0;
        if (n1>=n2){
            StringBuffer num = new StringBuffer();
            String str = "0";
            num.append(str.repeat(n1-n2));
            num.append(b1);
            b1 = num.toString();
            for (int i=n1-1; i>=0;i--){
                int a = Character.getNumericValue(a1.charAt(i));
                int b = Character.getNumericValue(b1.charAt(i));
                // Conditions
                if (a==0 && b==0 && c==0){
                    res.append('0');
                    c = 0;
                }
                else if (a==0 && b==0 && c==1){
                    res.append('1');
                    c = 0;
                }
                else if (a==0 && b==1 && c==0){
                    res.append('1');
                    c = 0;
                }
                else if (a==0 && b==1 && c==1){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==0 && c==0){
                    res.append('1');
                    c = 0;
                }
                else if (a==1 && b==0 && c==1){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==1 && c==0){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==1 && c==1){
                    res.append('1');
                    c = 1;
                }
            }

            if (c==1){res.append('1');}
            res = res.reverse();

        }

        // Else 
        else if (n2>n1){
            StringBuffer num = new StringBuffer();
            String str = "0";
            num.append(str.repeat(n2-n1));
            num.append(a1);
            a1 = num.toString();
            for (int i=n2-1; i>=0;i--){
                int a = Character.getNumericValue(a1.charAt(i));
                int b = Character.getNumericValue(b1.charAt(i));
                // Conditions
                if (a==0 && b==0 && c==0){
                    res.append('0');
                    c = 0;
                }
                else if (a==0 && b==0 && c==1){
                    res.append('1');
                    c = 0;
                }
                else if (a==0 && b==1 && c==0){
                    res.append('1');
                    c = 0;
                }
                else if (a==0 && b==1 && c==1){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==0 && c==0){
                    res.append('1');
                    c = 0;
                }
                else if (a==1 && b==0 && c==1){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==1 && c==0){
                    res.append('0');
                    c = 1;
                }
                else if (a==1 && b==1 && c==1){
                    res.append('1');
                    c = 1;
                }
            }

            if (c==1){res.append('1');}
            res = res.reverse();
            
        }


        return res.toString();
    }
}
