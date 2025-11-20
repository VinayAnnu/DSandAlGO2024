package LinkedList;

/// **
// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// */
public class Merge2SortedList {
    ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if (list1!=null) {
            temp.next = list1;
        }
        if (list2!=null) {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    // ✅ Helper to print linked list
    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Merge2SortedList obj = new Merge2SortedList();

        // ✅ List 1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // ✅ List 2: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("List 1:");
        obj.printList(list1);

        System.out.println("List 2:");
        obj.printList(list2);

        // ✅ Merge
        ListNode merged = obj.mergeTwoSortedList(list1, list2);

        System.out.println("Merged List:");
        obj.printList(merged);
    }
}
