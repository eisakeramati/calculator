/**
 * Created by eisak on 2017-10-09.
 */

import java.util.Stack;

public class stack {

    String s[];
    int top;
    int maxSize;

    public stack(int ms) {
        maxSize = ms;
        s = new String[maxSize];
        top = -1;
    }

    public void add(String x) {
        if (isFull()) return;
        else {
            top++;
            s[top] = x;
        }

    }

    public String delete() {
        if (isEmpty()) return "-1";

        else {
            String x = s[top];
            top--;
            return x;
        }

    }


    public boolean isFull() {
        if (top == maxSize) return true;

        else return false;
    }

    public boolean isEmpty() {

        if (top == -1) return true;
        else return false;
    }

}
