import java.util.*;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Rectangle 1 inside rectangle 2
        int x1r1 = rec1[0], x2r1 = rec1[2];
        int x1r2 = rec2[0], x2r2 = rec2[2];
        int y1r1 = rec1[1], y2r1 = rec1[3];
        int y1r2 = rec2[1], y2r2 = rec2[3];

        boolean overlap = false;
        if (((x1r1>x1r2 && x1r1<x2r2) || (x2r1>x1r2 && x2r1<x2r2)) && ((y1r1>y1r2 && y1r1<y2r2) || (y2r1>y1r2 && y2r1<y2r2))) overlap = true;
        if (((x1r2>x1r1 && x1r2<x2r1) || (x2r2>x1r1 && x2r2<x2r1)) && ((y1r2>y1r1 && y1r2<y2r1) || (y2r2>y1r1 && y2r2<y2r1))) overlap = true;
        if (((x1r1>x1r2 && x1r1<x2r2) || (x2r1>x1r2 && x2r1<x2r2)) && ((y1r2>y1r1 && y1r2<y2r1) || (y2r2>y1r1 && y2r2<y2r1))) overlap = true;
        if (((x1r2>x1r1 && x1r2<x2r1) || (x2r2>x1r1 && x2r2<x2r1)) && ((y1r1>y1r2 && y1r1<y2r2) || (y2r1>y1r2 && y2r1<y2r2))) overlap = true;

        // Proper overlap
        if (x1r1==x1r2 && x2r1==x2r2 && y1r1==y1r2 && y2r1==y2r2) overlap=true;
        return overlap;
    }
}