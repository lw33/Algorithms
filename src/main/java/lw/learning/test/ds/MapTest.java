package lw.learning.test.ds;

import lw.learning.ds.*;
import lw.learning.utils.ArrayHelper;
import lw.learning.utils.Book;
import lw.learning.utils.DSType;
import lw.learning.utils.TestHelper;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-27 19:43:23
 **/
public class MapTest {

    @Test
    public void test1() {
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        TestHelper.testMapTime(bstMap, Book.prideAndPrejudice);
        System.out.println(bstMap.get("pride"));
        System.out.println(bstMap.remove("pride"));
        System.out.println(bstMap.get("pride"));
    }

    @Test
    public void benchmark() {

        List<String> twoCities = Book.twoCities;
        //Collections.sort(twoCities);

        TestHelper.testDSTime(DSType.MAP, TreeMap.class, twoCities);
        TestHelper.testDSTime(DSType.MAP, HashMap.class, twoCities);

        TestHelper.testDSTime(DSType.MAP, AVLMap.class, twoCities);
        TestHelper.testDSTime(DSType.MAP, RBTreeMap.class, twoCities);
        TestHelper.testDSTime(DSType.MAP, BSTMap.class, twoCities);

        TestHelper.testDSTime(DSType.MAP, LinkedListMap.class, twoCities);
    }


}
