package lw.learning.test.ds;

import lw.learning.ds.Array;
import lw.learning.ds.ArrayStack;
import lw.learning.ds.LinkedListStack;
import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TestHelper;
import lw.learning.utils.TimeHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-26 22:30:17
 **/
public class ArrayTest {
    @Test
    public void benchmark() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        int[] arr = ArrayHelper.getRandomSizFixedArray(10000000, 1000000);

        TestHelper.testStackTime(arrayStack.getClass().getSimpleName(), arrayStack, arr);
        TestHelper.testStackTime(linkedListStack.getClass().getSimpleName(), linkedListStack, arr);
    }

    @Test
    public void test1() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        System.out.println(array);
        array.remove(1);
        System.out.println(array);
        array.remove(new Integer(1));
        System.out.println(array);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test3() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(0, 2);
        System.out.println(array);
    }


    @Test
    public void test4() {

        int n = 1000000000;



        long duration2 = TimeHelper.process(() -> {
            int value = 0;
            for (int i = 0; i < n; i++) {
                value = i;
            }
            System.out.println(value);
        });

        long duration1 = TimeHelper.process(() -> {
            Integer value = 0;
            for (int i = 0; i < n; i++) {
                value = i;
            }
            System.out.println(value);
        });
        System.out.println(duration1);
        System.out.println(duration2);
    }

}
