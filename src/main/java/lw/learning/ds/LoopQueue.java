package lw.learning.ds;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-27 10:10:42
 **/
public class LoopQueue<E> implements Queue<E> {

    private Object[] data;
    private int front;
    private int tail;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public LoopQueue(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(E e) {
        if (size == data.length) {
            resize(size * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = elementData(front);
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == (data.length >> 2) && (data.length >> 1) != 0) {
            resize(data.length >> 1);
        }
        return e;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) data[index];
    }

    @Override
    public E peek() {
        return elementData(front);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
