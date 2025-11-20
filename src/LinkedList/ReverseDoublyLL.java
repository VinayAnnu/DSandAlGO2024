package LinkedList;
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class ReverseDoublyLL {
    public Node reverse(Node head) {
        Node temp=null,curr=head;
        while(curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if(temp!=null){
            return temp.prev;
        }
        return head;
    }

    // ✅ Utility to print DLL
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // ✅ Create doubly linked list: 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        ReverseDoublyLL obj = new ReverseDoublyLL();

        System.out.println("Original List:");
        printList(head);

        // ✅ Reverse the doubly linked list
        head = obj.reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}
