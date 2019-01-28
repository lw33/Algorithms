package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 09:33:30
 **/
public class ArrayStack<E> implements Stack<E>{

    private Array<E> stack;

    public ArrayStack() {
        stack = new Array<>();
    }

    public ArrayStack(int initCapaticy) {
        this.stack = new Array<>(initCapaticy);
    }

    @Override
    public void push(E e) {
        stack.addLast(e);
    }

    @Override
    public E pop() {
        return stack.removeLast();
    }

    @Override
    public E peek() {
        return stack.getLast();
    }

    @Override
    public int search(E e) {
        return stack.indexOf(e);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + stack +
                '}';
    }
}
