class Solution {
    public List<Integer> getRow(int index) {
        
        List<List<Integer>> list  = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        List<Integer> temp = new ArrayList<>();
        Collections.addAll(temp,1,1);
        list.add(temp);
        if(index==0 || index==1) return list.get(index);
        
        for (int i=2; i<index+1; i++){
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            for (int j=0; j<temp.size()-1; j++){
                l1.add(temp.get(j)+temp.get(j+1));
            }
            l1.add(1);
            list.add(l1);
            temp = l1;
        }
        return list.get(index);
    }
}
