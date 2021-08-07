// Monotonic Stack 

class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
//         Stack & HashMap
        Stack<Integer> s = new Stack();
        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[arr1.length];
//         Push elements from arr2 in the stack
        for (int i=0; i<arr2.length; i++){
            while (!s.empty() && s.peek()<arr2[i]){
                map.put(s.pop(), arr2[i]);}
            s.push(arr2[i]);
        }
//         Map contains pairs of elements greater than that element
        for (int i=0; i<arr1.length; i++){
            if (map.containsKey(arr1[i])) res[i] = map.get(arr1[i]);
            else res[i] = -1;
        }
        return res;
    }
}
