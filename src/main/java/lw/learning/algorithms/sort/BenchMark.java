package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TestHelper;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-26 11:52:05
 **/
public class BenchMark {

    /**
     * -Xss128M
     * @param args
     */
    public static void main(String[] args) {
        int size = 1000000;
        int range = 1000000;
        int[] arr = ArrayHelper.getRandomSizFixedArray(size, range);
        //int[] arr = ArrayHelper.genNearlyOrderedArray(size, 0);

        // nlogn
        TestHelper.testSortTime(QuickSort.class.getSimpleName(), QuickSort::sort, arr);
        TestHelper.testSortTime(QuickSort.class.getSimpleName(), QuickSort::sort3way, arr);
        TestHelper.testSortTime(MergeSort.class.getSimpleName(), MergeSort::sort, arr);
        TestHelper.testSortTime(MergeSort.class.getSimpleName(), MergeSort::sortBu, arr);
        TestHelper.testSortTime(Arrays.class.getSimpleName(), Arrays::sort, arr);
        TestHelper.testSortTime(HeapSort.class.getSimpleName(), HeapSort::sort, arr);
        TestHelper.testSortTime(HeapSort.class.getSimpleName(), HeapSort::sort2, arr);


        TestHelper.testSortTime(ShellSort.class.getSimpleName(), ShellSort::sort, arr);

        // n ^ 2
        TestHelper.testSortTime(InsertionSort.class.getSimpleName(), InsertionSort::sort, arr);
        TestHelper.testSortTime(SelectionSort.class.getSimpleName(), SelectionSort::sort, arr);
        TestHelper.testSortTime(BubbleSort.class.getSimpleName(), BubbleSort::sort, arr);

    }
}
