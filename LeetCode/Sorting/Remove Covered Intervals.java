class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        // Sort 
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        
        // Create 2 lists
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        start.add(arr[0][0]);
        end.add(arr[0][1]);
        for(int i=1; i<arr.length; i++){
            int f = 0, c = arr[i][0], d = arr[i][1];
            for(int j=0; j<start.size(); j++){
                int a = start.get(j), b = end.get(j);
				// Case 1
                if(a<=c && b>=d){
                    f = 1;
                    break;
                }
				// Case 2
				else if(a==c && d>b){
                    end.set(j, d);
                    f=1;
                    break;
                }
            }
			// Case 3
            if(f==0){
                start.add(c);
                end.add(d);
            }
        }
        return start.size();
    }
}