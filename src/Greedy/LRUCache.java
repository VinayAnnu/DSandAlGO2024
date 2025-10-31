package Greedy;

import java.util.HashMap;
import java.util.Map;

class Node{
    Node prev,next;
    int key,val;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    static Map<Integer, Node> hm;
    static int capacity;
    static Node head,tail;
    LRUCache(int cap) {
        hm= new HashMap<>();
        capacity=cap;

        //initializing dummy head & tail
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public static int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node temp = hm.get(key);
        remove(temp);
        insertAtFront(temp);
        return temp.val;
    }


    public static void put(int key, int value) {
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }

        if(hm.size()==capacity){
            remove(tail.prev);// remove least recently used
        }
        insertAtFront(new Node(key, value));
    }

    public static void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        hm.remove(node.key);
    }
    public static void insertAtFront(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        hm.put(node.key,node);
    }

    // Helper method to print cache state (for debugging/demo)
    public void printCacheState() {
        Node current = head.next;
        System.out.print("Cache: ");
        while (current != tail) {
            System.out.print("(" + current.key + "," + current.val + ") ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.printCacheState(); // Cache: (2,2) (1,1)

        System.out.println("Get 1 => " + cache.get(1)); // Returns 1
        cache.printCacheState(); // Cache: (1,1) (2,2)

        cache.put(3, 3); // Evicts key 2
        cache.printCacheState(); // Cache: (3,3) (1,1)

        System.out.println("Get 2 => " + cache.get(2)); // Returns -1 (not found)

        cache.put(4, 4); // Evicts key 1
        cache.printCacheState(); // Cache: (4,4) (3,3)

        System.out.println("Get 1 => " + cache.get(1)); // Returns -1
        System.out.println("Get 3 => " + cache.get(3)); // Returns 3
        System.out.println("Get 4 => " + cache.get(4)); // Returns 4

        cache.printCacheState(); // Cache: (4,4) (3,3)
    }
}