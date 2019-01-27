package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-26 14:06:31
 **/
public class MergeSort {

    public static void main(String[] args) {
        TestHelper.testSort(MergeSort::sort);
        TestHelper.testSort(MergeSort::sortBu);
        System.out.println(ArrayHelper.compare(MergeSort::sort));
        System.out.println(ArrayHelper.compare(MergeSort::sortBu));
    }

    /**
     * 递归 自顶向下
     * @param arr
     */
    public static void sort(int[] arr) {

        int[] aux = new int[arr.length];

        sort(arr, aux, 0, arr.length - 1);
    }

    /**
     * 迭代 自底向上
     * @param arr
     */
    public static void sortBu(int[] arr) {
        int[] aux = new int[arr.length];
        for (int size = 1; size <= arr.length; size += size) {
            int dbSize = size + size;
            for (int i = 0; i + size < arr.length; i += dbSize) {
                merge(arr, aux, i, i + size - 1, Math.min(i + dbSize - 1, arr.length - 1));
            }
        }
    }

    public static void sort(int[] arr, int[] aux, int start, int end) {
        if (end - start <= 10) {
            InsertionSort.sort(arr, start, end);
        } else {

            if (end > start) {
                int mid = start + ((end - start) >> 1);
                sort(arr, aux, start, mid);
                sort(arr, aux, mid + 1, end);
                // 如果 两遍数据有序 则不需要 merge
                if (arr[mid] > arr[mid + 1]) {
                    merge(arr, aux, start, mid, end);
                }
            }
        }
    }

    public static void merge(int[] arr, int[] aux, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid + 1;
        int index = start;
        while (p1 <= mid && p2 <= end) {
            aux[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            aux[index++] = arr[p1++];
        }

        while (p2 <= end) {
            aux[index++] = arr[p2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = aux[i];
        }
    }
}
