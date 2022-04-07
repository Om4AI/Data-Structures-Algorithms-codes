class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> l = new ArrayList<>();
        for(int i: stones) l.add(i);
        
        while(l.size()>1){
            Collections.sort(l);
            int x = l.get(l.size()-2);
            int y = l.get(l.size()-1);
            
            l.remove(l.size()-2);
            l.remove(l.size()-1);
            if(x!=y) l.add(y-x);
        }
        return (l.size()==0)?0:l.get(0);
    }
}
