import java.util.*;
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head){
        if(head==null) return null;
        
        // Current node addition to list & processing
        Node temp = new Node(head.val);
        map.put(head, temp);
        
        // Map Node insertion - Create full list using Recursive function
        temp.next = copyRandomList(head.next);
        
        // Set value for random parameter
        temp.random = map.get(head.random);
        return temp;
    }
}