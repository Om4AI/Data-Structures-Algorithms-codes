// Code with Java Collections (ArrayList)

class Solution {
    public int[] n;

    public Solution(int[] nums) {
        n = nums;
    }
    

    public int[] reset() {
        return n;
    }
    

    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int i:n){list.add(i);}
//         Use Collections.shuffle() to shuffle in a random manner
        Collections.shuffle(list);
        int arr[] = new int[n.length];
        for (int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
