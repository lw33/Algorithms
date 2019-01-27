package lw.learning.test.ds;

import lw.learning.ds.Array;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-26 22:30:17
 **/
public class ArrayTest {
    
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
}
