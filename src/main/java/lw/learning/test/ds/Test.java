package lw.learning.test.ds;

import lw.learning.utils.ArrayHelper;
import lw.learning.utils.TimeHelper;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-12 09:43:48
 **/
public class Test {
    
    @org.junit.Test
    public void test() {
        int n = 9999999;
        int[] arr = ArrayHelper.getRandomSizFixedArray(n, n);
        int[][] tmp1 = new int[2][];
        long du1 = TimeHelper.process(() -> tmp1[0] = Arrays.copyOf(arr, arr.length));

        long du2 = TimeHelper.process(() -> {
            int[] arrTmp = tmp1[1] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrTmp[i] = arr[i];
            }
        });
        System.out.println(du1);
        System.out.println(du2);
        System.out.println(ArrayHelper.isEquals(tmp1[0], tmp1[1]));
    }
}
