package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.SortUtils;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-26 14:06:21
 **/
public class QuickSort {

    public static void main(String[] args) {

        TestHelper.testSort(QuickSort::sort);
        TestHelper.testSort(QuickSort::sort3way);
        System.out.println(ArrayHelper.compare(QuickSort::sort));
        System.out.println(ArrayHelper.compare(QuickSort::sort3way));
    }

    public static void sort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    public static void sort3way(int[] arr) {
        sort3way(arr, 0, arr.length - 1);
    }

    public static void sort3way(int[] arr, int start, int end) {
        if (end > start) {
            int[] partitions = partition3way(arr, start, end);
            sort3way(arr, start, partitions[0]);
            sort3way(arr, partitions[1], end);
        }
    }

    public static int[] partition3way(int[] arr, int start, int end) {
        // 随机快排
        int random = (int) (Math.random() * (end - start + 1) + start);
        SortUtils.swap(arr, random, end);
        int less = start - 1;
        int more = end;
        while (more > start) {
            if (arr[start] > arr[end]) {
                SortUtils.swap(arr, start, --more);
            } else if (arr[start] < arr[end]) {
                SortUtils.swap(arr, ++less, start++);
            } else {
                start++;
            }
        }
        SortUtils.swap(arr, more, end);
        return new int[]{less, more + 1};
    }

    public static void sort(int[] arr, int start, int end) {
        if (end > start) {
            int partition = partition(arr, start, end);
            sort(arr, start, partition - 1);
            sort(arr, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        // 随机快排
        int random = (int) (Math.random() * (end - start + 1) + start);
        SortUtils.swap(arr, random, end);
        int tmp = arr[end];
        int more = end;

        while (start < more) {
            if (arr[start] < tmp) {
                start++;
            } else {
                SortUtils.swap(arr, start, --more);
            }
        }
        SortUtils.swap(arr, more, end);
        return more;
    }
}
