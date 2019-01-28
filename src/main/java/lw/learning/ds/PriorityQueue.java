package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-28 11:26:52
 **/
public class PriorityQueue<E extends Comparable<E>>  implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(int initCapacity) {
        maxHeap = new MaxHeap<>(initCapacity);
    }

    @Override
    public void add(E e) {
        maxHeap.add(e);
    }

    @Override
    public E poll() {
        return  maxHeap.poll();
    }

    @Override
    public E peek() {
        return maxHeap.peek();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
