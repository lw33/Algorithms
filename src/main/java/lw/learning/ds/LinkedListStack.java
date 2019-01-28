package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 12:25:22
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int search(E e) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
