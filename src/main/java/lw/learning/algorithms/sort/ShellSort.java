package lw.learning.algorithms.sort;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TestHelper;

/**
 * @Author lw
 * @Date 2019-01-26 16:54:47
 **/
public class ShellSort {

    public static void main(String[] args) {
        TestHelper.testSort(ShellSort::sort);
        System.out.println(ArrayHelper.compare(ShellSort::sort));
    }

    public static void sort(int[] arr) {

        // 计算出最大的h值
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {

            for (int i = h; i < arr.length; i += h) {
                int tmp = arr[i];
                int j = i;
                for (; j > 0 && tmp < arr[j - h]; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = tmp;
            }

            h = (h - 1) / 3;
        }

    }
}
