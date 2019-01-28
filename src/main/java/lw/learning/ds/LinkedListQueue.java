package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 12:28:09
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> queue = new LinkedList<>();

    @Override
    public void add(E e) {
        queue.addLast(e);
    }

    @Override
    public E poll() {
        return queue.removeFirst();
    }

    @Override
    public E peek() {
        return queue.getFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
