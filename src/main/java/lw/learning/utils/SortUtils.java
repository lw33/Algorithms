package lw.learning.utils;

public class SortUtils {

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static boolean isEmptyOrLength(int[] arr) {

        return arr == null || arr.length == 0;

    }

    public static boolean isOrder(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
