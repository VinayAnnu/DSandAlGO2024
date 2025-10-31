package Recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStack {
    public void reverseStack(Deque<Integer> st) {
        if(st.isEmpty())return;
        int top=st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    public void insertAtBottom(Deque<Integer> st, int num){
        if(st.isEmpty()){
            st.push(num);
            return;
        }
        int top=st.pop();
        insertAtBottom(st,num);
        st.push(top);
    }

    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Original Stack: " + st);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverseStack(st);
        System.out.println("Reversed Stack: " + st);
    }
}
