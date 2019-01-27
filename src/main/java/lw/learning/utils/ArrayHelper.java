package lw.learning.utils;

import lw.learning.algorithms.sort.InsertionSort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2019-01-25 21:07:27
 **/
public class ArrayHelper {

    /**
     * @param size     array size [1, size]
     * @param range    array value range
     * @param positive array value symbol
     * @return random array
     */
    public static int[] genRandomArray(int size, boolean sizeFixed, boolean positive, int range) {
        int arrSize = sizeFixed ? size : (int) (Math.random() * size + 1);
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int) (positive ? range * Math.random() + 1 : (range + 1) * Math.random() - (range + 1) * Math.random());
        }
        return arr;
    }

    public static int[] genNearlyOrderedArray(int size, int swapTimes) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int i1 = (int) (Math.random() * size);
            int i2 = (int) (Math.random() * size);
            SortUtils.swap(arr, i1, i2);
        }

        return arr;
    }

    public static int[] getRandomSizFixedArray(int size, int range) {
        return genRandomArray(size, true, true, range);
    }

    public static int[] genPositiveRandomArray(int size, int value) {
        return genRandomArray(size, false, true, value);
    }

    public static int[] genRandomArray(int size, int value) {
        return genRandomArray(size, false, false, value);
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == arr2)
            return true;
        if (arr1 == null || arr2 == null)
            return false;

        int length = arr1.length;
        if (arr2.length != length)
            return false;

        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println(arr1[i]);
                System.out.println(arr2[i]);
                return false;
            }
        }

        return true;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 3, 3, 4};
        swap(integers, 1, 3);
        System.out.println(Arrays.toString(integers));
    }

    public static boolean compare(Consumer<int[]> sort1, Consumer<int[]> sort2, int[] arr) {
        int[] arr1 = copyArray(arr);
        int[] arr2 = copyArray(arr);
        sort1.accept(arr1);
        sort2.accept(arr2);
        boolean equals = isEquals(arr1, arr2);
        /*if (!equals) {
            System.out.println(Arrays.toString(arr1));
            System.out.println(SortUtils.isOrder(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(SortUtils.isOrder(arr2));
        }*/
        return equals;
    }

    /**
     * 以插入排序来作为基准
     *
     * @param sort
     * @return
     */
    public static boolean compare(Consumer<int[]> sort) {
        for (int i = 0; i < 10; i++) {
            int[] arr = getRandomSizFixedArray(100000, 1000000);
            if (!compare(InsertionSort::sort, sort, arr)) {
                return false;
            }
        }
        return true;
    }
}
