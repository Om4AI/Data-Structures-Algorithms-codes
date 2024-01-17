import java.util.*;

class RandomizedSet {
    HashSet<Integer> set;
    ArrayList<Integer> list;
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)){
            return false;
        }
        else{
            set.add(val);
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (set.contains(val)){
            set.remove(val);
            list.remove(list.indexOf(val));
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        Random obj = new Random();
        int random_index = obj.nextInt(set.size());
        return list.get(random_index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */