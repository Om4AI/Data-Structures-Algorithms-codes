class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i: a) l1.add(i);
        for(int i: b) l2.add(i);
        
        HashSet<Integer> set = new HashSet<>(l1);
        set.addAll(l2);
        return set.size();
    }
}
