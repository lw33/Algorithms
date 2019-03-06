package lw.learning.algorithms.search;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-03 07:31:23
 **/
public class BinarySearch {

    public static int search(int[] arr, int l, int r, int target) {

        while (r >= l) {
            int mid = l + ((r - l) >> 1);
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    public static int floor(int[] arr, int target) {
        int l = -1;
        int r = arr.length - 1;

        while (r > l) {

            int mid = l + ((r - l + 1) >> 1);

            if (arr[mid] >= target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid;
            }
        }

        // 如果 target 存在 返回第一个 target 的索引
        if (l + 1 < arr.length && arr[l + 1] == target) {
            return l + 1;
        }

        return l;
    }

    public static int ceil(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (r > l) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 如果 target 存在 返回最后一个 target 的索引
        if (r > 0 && arr[r - 1] == target) {
            return r - 1;
        }
        return r == arr.length ? -1 : r;
    }

    @Test
    public void test() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(floor(arr, 0));
        System.out.println(ceil(arr, 100));
    }
}
