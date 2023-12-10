import java.util.*;

class Node{
    Node next;
    Node prev;
    int key;
    int val;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class Solution {
    public static int size;
    public static Node head;
    public static Node tail;
    public static HashMap<Integer, Node> map;

    public static void addNode(Node newNode){
        Node secondLast = tail.prev;
        secondLast.next = newNode;
        newNode.next = tail;
        newNode.prev = secondLast;
        tail.prev = newNode;
    }

    public static void deleteNode(Node delNode){
        Node prev_delNode = delNode.prev;
        Node next_delNode = delNode.next;
        prev_delNode.next = next_delNode;
        next_delNode.prev = prev_delNode;
    }

    public Solution(int capacity){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;

        size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            // Update LRU node
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            // Delete previous node with that key
            Node previous = map.get(key);
            deleteNode(previous);

            // Add new node
            Node newNode = new Node(key,value);
            addNode(newNode);
            map.put(key,newNode);
        }else{
            // Still space is left
            if (map.size()<size){
                Node newNode = new Node(key,value);
                addNode(newNode);
                map.put(key, newNode);
            }else{
                // Remove LRU node - (Node definition requires Key value for this)
                Node lruNode = head.next;
                map.remove(lruNode.key);
                deleteNode(lruNode);

                // Add new Node
                Node newNode = new Node(key,value);
                addNode(newNode);
                map.put(key, newNode);
            }
        }
    }
}
