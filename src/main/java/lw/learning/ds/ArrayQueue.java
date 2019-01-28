package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 09:55:19
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> queue;

    public ArrayQueue(int initCapacity) {
        this.queue = new Array<>(initCapacity);
    }

    public ArrayQueue() {
        this.queue = new Array<>();
    }

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

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "queue=" + queue +
                '}';
    }
}
