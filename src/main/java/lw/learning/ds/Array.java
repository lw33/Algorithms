package lw.learning.ds;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-26 21:50:52
 **/
public class Array<E> {

    private Object[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    // add
    public void add(E element) {
        ensureCapacity();
        data[size++] = element;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(element);
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    // delete

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementData(index);
        fastRemove(index);
        return oldValue;
    }

    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i != -1) {
            fastRemove(i);
            return true;
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
    }

    // update
    public E set(int index, E e) {
        rangeCheck(index);
        E oldValue = elementData(index);
        data[index] = e;
        return oldValue;
    }


    // search
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) data[index];
    }

    public boolean contains(Object o) {
        return indexOf(o) > 0;
    }

    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // help
    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    private void ensureCapacity() {
        if (data.length == size) {
            resize(size << 1);
        }
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i] + ", ");
        }
        sb.append(data[size - 1] + "]");
        return sb.toString();
    }
}
