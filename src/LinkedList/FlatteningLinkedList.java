package LinkedList;

import java.util.PriorityQueue;

//approach-1
class Node1 {
    int data;
    Node1 next;
    Node1 bottom;

    Node1(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
//public class FlatteningLinkedList {
//    public Node1 merge2SortedList(Node1 head1,Node1 head2){
//        Node1 t1=head1,t2=head2;
//        Node1 dummyNode = new Node1(-1);
//        Node1 temp=dummyNode;
//        while(t1!=null&&t2!=null){
//            if(t1.data<t2.data){
//                temp.bottom=t1;
//                t1=t1.bottom;
//            }else{
//                temp.bottom=t2;
//                t2=t2.bottom;
//            }
//            temp=temp.bottom;
//            temp.next=null;
//        }
//        if(t1!=null){
//            temp.bottom=t1;
//        }
//        if(t2!=null){
//            temp.bottom=t2;
//        }
//        return dummyNode.bottom;
//    }
//
//    public Node1 helper(Node1 head){
//        //base case
//        if(head==null||head.next==null){
//            return head;
//        }
//        Node1 mergedHead = helper(head.next);
//        return merge2SortedList(head,mergedHead);
//    }
//    public Node1 flatten(Node1 root) {
//        if(root==null)return root;
//        return helper(root);
//
//    }
//
//    // Utility method to print flattened list
//    public static void printList(Node1 head) {
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.bottom;
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        // Creating the multilevel linked list:
//        // Level 1: 5 -> 10 -> 19 -> 28
//        // Level 2 bottom chains:
//        // 5  -> 7 -> 8 -> 30
//        // 10 -> 20
//        // 19 -> 22 -> 50
//        // 28 -> 35 -> 40 -> 45
//
//        Node1 root = new Node1(5);
//        root.next = new Node1(10);
//        root.next.next = new Node1(19);
//        root.next.next.next = new Node1(28);
//
//        root.bottom = new Node1(7);
//        root.bottom.bottom = new Node1(8);
//        root.bottom.bottom.bottom = new Node1(30);
//
//        root.next.bottom = new Node1(20);
//
//        root.next.next.bottom = new Node1(22);
//        root.next.next.bottom.bottom = new Node1(50);
//
//        root.next.next.next.bottom = new Node1(35);
//        root.next.next.next.bottom.bottom = new Node1(40);
//        root.next.next.next.bottom.bottom.bottom = new Node1(45);
//
//        FlatteningLinkedList sol = new FlatteningLinkedList();
//        Node1 flat = sol.flatten(root);
//
//        // Print the flattened list
//        printList(flat);
//    }
//}

//approach-2
class Pair{
    int val;
    Node1 node;
    Pair(int val,Node1 n){
        this.val=val;
        this.node=n;
    }
}
public class FlatteningLinkedList {
    public Node1 flatten(Node1 root) {
        if(root==null)return root;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2)->Integer.compare(p1.val,p2.val));
        Node1 temp=root;
        while(temp!=null){
            pq.add(new Pair(temp.data,temp));
            temp=temp.next;
        }

        Node1 dummyNode = new Node1(-1);
        Node1 temp2=dummyNode;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            temp2.bottom=p.node;
            temp2=temp2.bottom;
            temp2.next=null;
            if(p.node.bottom!=null){
                pq.add(new Pair(p.node.bottom.data,p.node.bottom));
            }
        }
        return dummyNode.bottom;
    }
    // Utility method to print flattened list
    public static void printList(Node1 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating the multilevel linked list:
        // Level 1: 5 -> 10 -> 19 -> 28
        // Level 2 bottom chains:
        // 5  -> 7 -> 8 -> 30
        // 10 -> 20
        // 19 -> 22 -> 50
        // 28 -> 35 -> 40 -> 45

        Node1 root = new Node1(5);
        root.next = new Node1(10);
        root.next.next = new Node1(19);
        root.next.next.next = new Node1(28);

        root.bottom = new Node1(7);
        root.bottom.bottom = new Node1(8);
        root.bottom.bottom.bottom = new Node1(30);

        root.next.bottom = new Node1(20);

        root.next.next.bottom = new Node1(22);
        root.next.next.bottom.bottom = new Node1(50);

        root.next.next.next.bottom = new Node1(35);
        root.next.next.next.bottom.bottom = new Node1(40);
        root.next.next.next.bottom.bottom.bottom = new Node1(45);

        FlatteningLinkedList sol = new FlatteningLinkedList();
        Node1 flat = sol.flatten(root);

        // Print the flattened list
        printList(flat);
    }
}
