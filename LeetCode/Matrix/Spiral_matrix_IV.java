/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 import java.util.*;

 class Solution {
     public int[][] spiralMatrix(int m, int n, ListNode head){
         List<Integer> vals = new ArrayList<>();
         while(head!=null){
             vals.add(head.val);
             head = head.next;
         }
         int p = 0;
 
         // Create resultant matrix and initialize with -1(for empty spaces condition)
         int[][] res = new int[m][n];
         for(int i=0; i<m; i++) Arrays.fill(res[i], -1);
 
         // Spiral Traversal and Filling matrix
         int l = 0, r = n-1, u = 0, d = m-1;
         while(l<=r && u<=d && p<vals.size()){
             // Movement: l->r
             for(int i=l; i<=r; i++){
                 if(p<vals.size()){
                     res[u][i] = vals.get(p);
                     p++;
                 }
             }
             u++;
 
             // Movement: u->d
             for(int i=u; i<=d; i++){
                 if(p<vals.size()){
                     res[i][r] = vals.get(p);
                     p++;
                 }
             }
             r--;
 
             // Movement: r->l
             // Condition: Ensures that there are 2 rows (=====) and that we are not coming in  the opposite direction
             if(d>=u){
                 for(int i=r; i>=l; i--){
                     if(p<vals.size()){
                         res[d][i] = vals.get(p);
                         p++;
                     }
                 }
                 d--;
             }
 
             // Movement: d->u
             // Condition: Ensures that there are 2 columns (||) and that we are not coming in  the opposite direction upwards
             if(r>=l){
                 for(int i=d; i>=u; i--){
                     if(p<vals.size()){
                         res[i][l] = vals.get(p);
                         p++;
                     }
                 }
                 l++;
             }
         }
         return res;
     }
 }