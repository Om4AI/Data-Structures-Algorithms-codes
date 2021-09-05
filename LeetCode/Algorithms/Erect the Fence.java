// Code by @Om
import java.util.*;
class Solution {

    public static int get_crossproduct(int a,int b,int c, int d,int e, int f){
        int x1 = a-c, x2 = a-e;
        int y1 = b-d, y2 = b-f;
        return (y2*x1  - y1*x2);
    }

    public static int check_dist(int a,int b,int c, int d,int e, int f){
        double d1 =  Math.sqrt(Math.pow((c-a),2)+Math.pow((d-b),2));
        double d2 =  Math.sqrt(Math.pow((e-a),2)+Math.pow((f-b),2));
        if (d1<d2) return 0;
        else return 1;
    }


    static int[][] outerTrees(int[][] points){

        HashSet<List<Integer>> res = new HashSet<>();

        // Find leftmost point
        int s_x = points[0][0], s_y = points[0][1];
        for (int i=1; i<points.length; i++){
            if (points[i][0]<s_x){
                s_x = points[i][0];
                s_y = points[i][1];
            }
        }
        int c_x = s_x, c_y = s_y;
        List<Integer> m = new ArrayList<>();
        m.add(s_x);
        m.add(s_y);
        res.add(m);
        List<List<Integer>> collinear = new ArrayList<>();
        // Actual Jarvis Algo
        while (true){
            // Second point
            int nt_x = points[0][0], nt_y = points[0][1];
            // Third point
            for (int i=1; i<points.length; i++){

                int p_x = points[i][0], p_y = points[i][1];
                // Same as the starting point
                if (p_x==s_x && p_y==s_y){
                    continue;
                }

                int cp = get_crossproduct(s_x, s_y, nt_x, nt_y, p_x, p_y);
                if (cp>0){
                    // Point is on the left of the line
                    nt_x = p_x;
                    nt_y = p_y;
                    collinear = new ArrayList<>();
                }else if (cp==0){
                    List<Integer> t = new ArrayList<>();
                    // Check distance
                    if (check_dist(s_x,s_y,nt_x,nt_y,p_x,p_y)==0){
                        // nt_x, nt_y is closer & goes into collinear
                        t.add(nt_x);
                        t.add(nt_y);
                        collinear.add(t);
                        nt_x = p_x; 
                        nt_y = p_y;
                    }else{
                        // p_x, p_y is closer & goes into collinear
                        t.add(p_x);
                        t.add(p_y);
                        collinear.add(t);
                    }
                } // Ignore the point if its on the right
            } // Leftmost point identified


            res.addAll(collinear);
            if (nt_x==c_x && nt_y==c_y){
                break;
            }

            List<Integer> t = new ArrayList<>();
            t.add(nt_x);
            t.add(nt_y);
            res.add(t);

            s_x = nt_x;
            s_y = nt_y;
        }
        int[][] result= new int[res.size()][2];
        List<List<Integer>> l = new ArrayList<>(res);
        for (int i=0; i<l.size(); i++){
            result[i][0] = l.get(i).get(0);
            result[i][1] = l.get(i).get(1);
        }
        return result;
    } 
}
