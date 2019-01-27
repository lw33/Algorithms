package lw.learning.algorithms.sort;

import lw.learning.ds.MinHeap;
import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-26 18:44:47
 **/
public class HeapSort {

    public static void main(String[] args) {
        TestHelper.testSort(HeapSort::sort);
        System.out.println(ArrayHelper.compare(HeapSort::sort));

    }

    public static void sort(int[] arr) {
        //MinHeap minHeap = new MinHeap(arr.length);
        //for (int i : arr) {
        //    minHeap.add(i);
        //}
        MinHeap minHeap = new MinHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }
    public static void sort2(int[] arr) {
        MinHeap minHeap = new MinHeap(arr.length);
        for (int i : arr) {
            minHeap.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }
    }
}
