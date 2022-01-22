import java.util.*;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max_len = 0;
        // Each nums1 element
        for (int i=0; i<nums1.length; i++){
            int f = 0, j;
            // Inside nums2
            for (j=0; j<nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    f = 1;
                    if (f==1){
                        // Maximum Subarray
                        int n1=i, n2=j, temp_count=0;
                        while(n1<nums1.length && n2<nums2.length){
                            if (nums1[n1] == nums2[n2]){
                                temp_count+=1;
                                n1+=1;
                                n2+=1;
                            }
                            else{
                                break;
                            } 
                        }
        
                        // Check for max subarray
                        if (temp_count > max_len){max_len = temp_count;}
                    }
                }
            }
        }
        return max_len;   
    }
}
