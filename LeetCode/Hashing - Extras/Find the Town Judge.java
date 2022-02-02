class Solution {
    public int findJudge(int n, int[][] trust) {

        int j = 0, n1 = trust.length;
        HashSet<Integer> set = new HashSet<>();

        // Base conditions
        if(n==n1) return -1;
        if(n==1 && n1==0) return 1;

        for (int i=0; i<n1; i++){
            set.add(trust[i][0]);
        }

        // Person who doesn't trust anyone
        for (int i=1; i<=n; i++) if(!set.contains(i)) j = i;

        // Find person who everyone trusts
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n1; i++){
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0)+1);
        }

        // Check person
        for(int k: map.keySet()){
            if(map.get(k)==n-1 && k==j) return j;
        }
        return -1;
    }
}