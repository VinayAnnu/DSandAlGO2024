package LinkedList;

public class SortLinkedListHaving012Val {
    public ListNode segregate(ListNode head) {
        ListNode dummyZero = new ListNode(-1);
        ListNode dummyOne = new ListNode(-1);
        ListNode dummyTwo = new ListNode(-1);

        ListNode tempZero = dummyZero;
        ListNode tempOne = dummyOne;
        ListNode tempTwo = dummyTwo;

        ListNode temp=head;
        while(temp!=null){
            if(temp.val==0){
                tempZero.next=temp;
                tempZero=temp;
            }else if(temp.val==1){
                tempOne.next=temp;
                tempOne=temp;
            }else{
                tempTwo.next=temp;
                tempTwo=temp;
            }
            temp=temp.next;
        }

        tempZero.next=dummyOne.next!=null?dummyOne.next:dummyTwo.next;
        tempOne.next=dummyTwo.next;
        tempTwo.next=null;
        return dummyZero.next;
    }
}
