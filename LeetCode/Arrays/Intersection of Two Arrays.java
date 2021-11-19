class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
//       Arrays to sets
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

//       Actual Intersection Code XD
    set1.retainAll(set2);
      
//     Set to Array
    int [] res = new int[set1.size()];
    int i = 0;
    for (int s : set1) res[i++] = s;
    return res;
  }
}
