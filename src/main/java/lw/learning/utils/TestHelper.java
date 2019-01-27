package lw.learning.utils;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2019-01-25 21:29:58
 **/
public class TestHelper {


    public static void testSort(Consumer<int[]> consumer) {
        testSort(10, 100, 100, consumer);
    }

    public static void testSort(int times, int size, int range, Consumer<int[]> consumer) {
        for (int i = 0; i < times; i++) {
            int[] ints = ArrayHelper.genPositiveRandomArray(size, range);
            System.out.println(Arrays.toString(ints));
            System.out.println("is order: " + SortUtils.isOrder(ints));
            consumer.accept(ints);
            System.out.println("start order...");
            System.out.println(Arrays.toString(ints));
            System.out.println("is order: " + SortUtils.isOrder(ints));
            System.out.println("\n=========================================================\n");
        }
    }

    public static void testSortTime(String[] sortNames, Consumer<int[]>[] consumers, int[] arr) {

        for (int i = 0; i < sortNames.length; i++) {
            long duration = TimeHelper.process(consumers[i], arr);
            System.out.println(sortNames[i] + ": " + duration);
        }
    }

    public static void testSortTime(String sortName, Consumer<int[]> consumer, int[] arr) {
        int[] sortArray = Arrays.copyOf(arr, arr.length);
        long duration = TimeHelper.process(consumer, sortArray);
        System.out.println(sortName + ": " + duration + " ms");
    }

}
