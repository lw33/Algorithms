package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;

/**
 * @Author lw
 * @Date 2019-01-26 17:12:32
 **/
public class MaxHeap {

    private int[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = new int[capacity];
        count = 0;
    }

    public MaxHeap(int[] data) {
        this.data = ArrayHelper.copyArray(data);
        count = data.length;
        for (int i = parent(data.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void add(int e) {
        data[count] = e;
        shiftUp(count);
        count++;
    }

    public int poll() {
        int res = data[0];
        count--;
        data[0] = data[count];
        shiftDown(0);
        return res;
    }

    private void shiftDown(int k) {
        int x = data[k];
        int i;
        while ((i = left(k)) < count) {
            if (i + 1 < count && data[i] < data[i + 1]) {
                i++;
            }
            if (x >= data[i]) {
                break;
            }
            //swap(i, k);
            data[k] = data[i];
            k = i;
        }
        data[k] = x;
    }

    private void shiftUp(int k) {
        int x = data[k];
        while (k > 0) {
            int parent = parent(k);
            int e = data[parent];
            if (x <= data[parent]) {
                break;
            }
            data[k] = e;
            k = parent;
        }
        data[k] = x;
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
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

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


}
