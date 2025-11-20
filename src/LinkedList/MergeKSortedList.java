package LinkedList;

import java.util.PriorityQueue;

class Node2 {
    int data;
    Node2 next;

    Node2(int x) {
        data = x;
        next = null;
    }
}
class Pair2{
    int val;
    Node2 node;
    Pair2(int val,Node2 n){
        this.val=val;
        this.node=n;
    }
}
public class MergeKSortedList {
    public Node2 mergeKLists(Node2[] arr) {
        if(arr.length==0)return null;
        PriorityQueue<Pair2> pq = new PriorityQueue<>((p1, p2)->Integer.compare(p1.val,p2.val));
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair2(arr[i].data,arr[i]));
        }
        Node2 dummyNode = new Node2(-1);
        Node2 temp=dummyNode;
        while(!pq.isEmpty()){
            Pair2 p = pq.poll();
            temp.next=p.node;
            temp=temp.next;
            if(p.node.next!=null){
                pq.add(new Pair2(p.node.next.data,p.node.next));
            }
        }
        return dummyNode.next;
    }

    // Helper function to print linked list
    public static void printList(Node2 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // -------- Create List 1: 1 -> 4 -> 5 --------
        Node2 a1 = new Node2(1);
        a1.next = new Node2(4);
        a1.next.next = new Node2(5);

        // -------- Create List 2: 1 -> 3 -> 4 --------
        Node2 a2 = new Node2(1);
        a2.next = new Node2(3);
        a2.next.next = new Node2(4);

        // -------- Create List 3: 2 -> 6 --------
        Node2 a3 = new Node2(2);
        a3.next = new Node2(6);

        // Put them into array
        Node2[] arr = new Node2[]{a1, a2, a3};

        // Call mergeKLists
        MergeKSortedList sol = new MergeKSortedList();
        Node2 result = sol.mergeKLists(arr);

        // Print final merged list
        printList(result);
    }
}
