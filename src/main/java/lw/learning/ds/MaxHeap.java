package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-28 09:45:36
 **/
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int initCapacity) {
        data = new Array<>(initCapacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public void add(E e) {
        data.addLast(e);
        shiftUp(data.size() - 1, e);
    }

    private void shiftUp(int k, E e) {

        while (k > 0) {
            int parent = parent(k);
            E parentValue = data.get(parent);
            if (parentValue.compareTo(e) >= 0) {
                break;
            }

            data.set(k, parentValue);
            k = parent;
        }
        data.set(k, e);
    }

    public E poll() {
        E head = data.removeLast();
        if (isEmpty()) {
            return head;
        }
        E max = data.set(0, head);
        shiftDown(0, head);
        return max;
    }

    private void shiftDown(int k, E e) {

        int i;
        while ((i = left(k)) < data.size()) {
            if (i + 1 < data.size() && data.get(i).compareTo(data.get(i + 1)) < 0) {
                ++i;
            }
            E child = data.get(i);
            if (e.compareTo(child) >= 0) {
                break;
            }
            data.set(k, data.get(i));
            k = i;
        }
        data.set(k, e);
    }

    public E peek() {
        return data.get(0);
    }


    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    private int left(int index) {
        return (index << 1) + 1;
    }

    private int right(int index) {
        return (index << 1) + 2;
    }
}
