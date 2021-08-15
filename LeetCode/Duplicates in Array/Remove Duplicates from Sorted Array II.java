// Code by @Om
class Solution {
    public int removeDuplicates(int[] arr) {
        List<Integer> l = new ArrayList();
        int n=0, count = 0;
        for (int i=0; i<arr.length; i++){
            int el = arr[i];
            if (el != n){
                n = el;
                count = 1;
                l.add(el);
            }else{
                count++;
                if (count <= 2){
                    l.add(el);
                }
            }
        } 
        
        // Modify array
        for (int i=0; i<l.size(); i++) {
            arr[i] = l.get(i);
        }
        return l.size();
    }
}
