package lw.learning.test.ds;

import lw.learning.ds.MaxHeap;
import lw.learning.utils.ArrayHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-28 11:11:11
 **/
public class HeapTest {
    
    @Test
    public void test1() {
        int[] arr = ArrayHelper.getRandomSizFixedArray(20, 30);
        MaxHeap<Integer> heap = new MaxHeap<>();
        int[] res = new int[arr.length];
        for (int i : arr) {
            heap.add(i);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        System.out.println(Arrays.toString(res));
    }
}
