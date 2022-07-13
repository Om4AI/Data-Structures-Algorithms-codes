class MyLinkedList {
    public static List<Integer> l;
    public MyLinkedList() {
        l = new ArrayList<>();
    }
    
    public int get(int index) {
        if(index<l.size()) return l.get(index);
        return -1;
    }
    
    public void addAtHead(int val) {
        l.add(0,val);
    }
    
    public void addAtTail(int val) {
        l.add(val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index<l.size()) l.add(index,val);
        else if(index==l.size()) l.add(val);
    }
    
    public void deleteAtIndex(int index) {
        if(index<l.size()) l.remove(index);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
