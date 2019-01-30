package lw.learning.test.ds;

import lw.learning.ds.BST;
import lw.learning.utils.ArrayHelper;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-27 16:34:05
 **/
public class BSTTest {

    @Test
    public void test() {

        BST<Integer> bst = new BST<>();
        int[] arr = ArrayHelper.getRandomSizFixedArray(1000, 10000);
        for (int i : arr) {
            bst.add(i);
        }
        bst.inOrder();
        for (int i : arr) {
            bst.remove(i);
        }
        bst.inOrder();
    }
}
