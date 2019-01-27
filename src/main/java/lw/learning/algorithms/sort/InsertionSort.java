package lw.learning.algorithms.sort;

import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-26 11:56:38
 **/
public class InsertionSort {

    public static void main(String[] args) {
        TestHelper.testSort(InsertionSort::sort);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
           /* for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SortUtils.swap(arr, j, j - 1);
            }*/
            int tmp = arr[i];
            int j = i;
            for (; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void sort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int j = i;
            int tmp = arr[i];
            for (; j > start && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }
}
