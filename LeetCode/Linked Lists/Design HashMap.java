
// Implementation using ARRAYLIST 

class MyHashMap {
    
    List<List<Integer>> list;
    public MyHashMap(){
         list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int put = 0;
        for (int i=0; i<list.size(); i++){
            if(list.get(i).get(0)==key){
                List<Integer> t = new ArrayList<>();
                t.add(key);
                t.add(value);
                list.set(i, t);
                put= 1;
            } 
        }

        if(put==0){
            List<Integer> t = new ArrayList<>();
            t.add(key);
            t.add(value);
            list.add(t);
        }
    }
    
    public int get(int key) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).get(0)==key) return list.get(i).get(1);
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = 0, found = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).get(0)==key){
                index = i;
                found = 1;
            }
        }
        if(found==1){list.remove(index);}
    }
}
