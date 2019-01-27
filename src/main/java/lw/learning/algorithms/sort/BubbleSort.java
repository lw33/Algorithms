package lw.learning.algorithms.sort;

import lw.learning.utils.SortUtils;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-25 21:42:41
 **/
public class BubbleSort {

    public static void main(String[] args) {
        TestHelper.testSort(BubbleSort::sort);
    }

    public static void sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }

        /*for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtils.swap(arr, j, j-1);
                }
            }
            *//*for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }*//*
        }*/
    }
}
