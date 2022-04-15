import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int k){
        int n = points.length;
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int i=0; i<n; i++){
            int dist = points[i][0]*points[i][0] +points[i][1]*points[i][1];
            int temp[] = new int[3];
            temp[0] = dist;
            temp[1] = points[i][0];
            temp[2] = points[i][1];
            maxheap.add(temp);
            if(maxheap.size()>k) maxheap.poll();
        }
        List<int[]> l = new ArrayList<>();
        while(!maxheap.isEmpty()){
            int temp[] = maxheap.poll();
            int x = (int)temp[1];
            int y = (int)temp[2];
            int t[] = new int[2];
            t[0] = x;
            t[1] = y;
            l.add(t);
        }
        int res[][] = new int[l.size()][2];
        int i = 0;
        for(int[] z: l){
            res[i] = z;
            i++;
        }
        return res;
    }
}