// Solution: Method 1

class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}




// Method 2
class Solution {
    public String largestNumber(int[] arr) {
        
        int n = arr.length;
        if (n==0) return "";
        
        String str[] = new String[n];
//         Convert to strings
        for (int i=0; i<n; i++){
            str[i] = Integer.toString(arr[i]);
        }
//         Lexicographically sort the numbers that are in string form
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
//         Print String Array
        StringBuffer sb = new StringBuffer();
        
//         Case with all 0s' otherwise 0 will never come at the start
        if (str[0].equals("0")) 
            return "0";
        for (int i=0; i<str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
