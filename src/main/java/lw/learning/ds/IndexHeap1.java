package lw.learning.ds;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2019-01-30 14:59:36
 **/
public class IndexHeap1<E> {

    private Object[] data;
    private int[] indexes;

    private int size;

    private Comparator<E> comparator;

    public IndexHeap1(int capacity, Comparator<E> comparator) {
        this.comparator = comparator;
        data = new Object[capacity];
        indexes = new int[capacity];
    }

    public void add(int i, E e) {
        if (i < 0 || i > size) {
            return;
        }

        data[i] = e;
        indexes[size] = size;
        shiftUp(size);
        size++;
    }




    public void change(int i, E e) {

        data[i] = e;
        for (int j = 0; j < size; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    public E poll() {

        int maxIndex = indexes[0];
        E max = elementData(maxIndex);
        data[maxIndex] = null;
        size--;
        indexes[0] = indexes[size];
        //indexes[size] = -1;
        shiftDown(0);
        return max;
    }
    public int pollIndex() {

        int maxIndex = indexes[0];
        size--;
        indexes[0] = indexes[size];
        shiftDown(0);
        return maxIndex;
    }

    public E get(int i) {
        return elementData(i);
    }

    public E peek() {
        return elementData(indexes[0]);
    }

    private void shiftUp(int k) {
        int x = indexes[k];
        while (k > 0) {
            int parent = parent(k);
            int parentIndex = indexes[parent];
            if (comparator.compare(elementData(x), elementData(parentIndex)) <= 0) {
                break;
            }
            indexes[k] = parentIndex;
            k = parent;
        }
        indexes[k] = x;
    }


    private void shiftDown(int k) {
        int x = indexes[k];
        int i;
        while ((i = left(k)) < size) {
            if (i + 1 < size &&
                    comparator.compare(elementData(indexes[i]), elementData(indexes[i + 1])) < 0) {
                ++i;
            }

            if (comparator.compare(elementData(x), elementData(indexes[i])) >= 0) {
                break;
            }

            indexes[k] = indexes[i];
            k = i;
        }

        indexes[k] = x;
    }


    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) data[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int i) {
        return (i - 1) >>> 1;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {

        return i * 2 + 2;
    }

    public static void main(String[] args) {

        IndexHeap1<Integer> integerIndexHeap1 = new IndexHeap1<>(10, Integer::compare);
        for (int i = 0; i < 10; i++) {
            integerIndexHeap1.add(i, i);
        }
        integerIndexHeap1.change(9, -1);
        for (int i = 0; i < 10; i++) {
            System.out.println(integerIndexHeap1.poll());
        }
        System.out.println(Arrays.toString(integerIndexHeap1.data));
        System.out.println(Arrays.toString(integerIndexHeap1.indexes));
        System.out.println(integerIndexHeap1.size);
    }
}
