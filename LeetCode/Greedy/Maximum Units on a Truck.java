class Solution {
    public int maximumUnits(int[][] box, int capa) {
        Arrays.sort(box, (a,b)->(b[1]-a[1]));
        
        int c = 0, p=0, n=box.length;
        while(p<n && capa!=0){
            int boxes = box[p][0], units = box[p][1];
            if(boxes<capa){
                c+=boxes*units;
                capa-=boxes;
            }else{
                c+=capa*units;
                capa =0;
            }
            p++;
        }
        return c;
    }
}
