package LinkedList;

public class SortList {
    ListNode findMid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode mergeTwoSortedList(ListNode list1, ListNode list2){
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }

        if(list1!=null){
            temp.next=list1;
        }
        if(list2!=null){
            temp.next=list2;
        }
        return dummyNode.next;
    }

    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode leftHead=head;
        ListNode rightHead=mid.next;
        mid.next=null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return mergeTwoSortedList(leftHead,rightHead);
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
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
        SortList obj = new SortList();
        // ✅ List 1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(3);
        System.out.println("List 1:");
        obj.printList(list1);
        System.out.println("Sorted List:");
        ListNode sortedHead = obj.sortList(list1);
        obj.printList(sortedHead);
    }
}
