package lw.learning.test.ds;

import lw.learning.ds.ArrayStack;
import lw.learning.ds.Stack;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-27 09:37:52
 **/
public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.peek();
        stack.pop();
        System.out.println(stack);
    }
}
