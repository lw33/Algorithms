package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.SortUtils;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-25 21:28:52
 **/
public class SelectionSort {

    public static void main(String[] args) {
        TestHelper.testSort(SelectionSort::sort);
        TestHelper.testSortTime(SelectionSort.class.getSimpleName(), SelectionSort::sort, ArrayHelper.getRandomSizFixedArray(100000, 100000));
        System.out.println(ArrayHelper.compare(SelectionSort::sort));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
               /* if (arr[i] > arr[j]) {
                    SortUtils.swap(arr, i, j);
                }*/
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(arr, minIndex, i);
        }
    }
}
