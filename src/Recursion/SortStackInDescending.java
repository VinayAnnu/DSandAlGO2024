package Recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SortStackInDescending {
    public void sortStack(Deque<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        sortStack(st);
        //inserts a number into the correct place in the sorted stack.
        insertSorted(st, top);
    }

    public void insertSorted(Deque<Integer> st, int num){
        // Base case: either stack is empty or top is smaller/equal
        if (st.isEmpty() || num>=st.peek()) {
            st.push(num);
            return;
        }

        int top = st.pop();
        insertSorted(st, num);
        st.push(top);
    }

    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();

        // Sample input
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);
        st.push(5);

        System.out.println("Original Stack (top -> rightmost): " + st);

        SortStackInDescending sol = new SortStackInDescending();
        sol.sortStack(st);

        System.out.println("Sorted Stack (descending, top -> rightmost): " + st);
    }
}
