package easy;

//Java program to implement getMin() in O(1).

/*
*Boolean sql injection
* select * from tbl where userid = 2 or 1=1;(Boolean)
* Time-based sql injection
* select * from tbl2 where usereId = 3 + SLEEP(5)(Time-based)
* Error-based sql injection(deliberately sends incorrect data inorder to get error code
* Union-based sql injections
* */

//

import java.util.Stack;
public class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    public void push(int data) {
        int min = data;
        if(!minSt.isEmpty() && min > minSt.peek()) {
            min = minSt.peek();
        }
        st.push(data);
        minSt.push(min);
    }
    public void pop() {
        st.pop();
        minSt.pop();
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return minSt.peek();
    }
    public static void main(String[] args) {
        MinStack minElem = new MinStack();
        minElem.push(4);
        minElem.push(5);
        minElem.push(8);
        minElem.push(1);
        minElem.pop();
        System.out.println(" Minimum Element from Stack " + minElem.getMin());
    }
}
