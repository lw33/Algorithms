package lw.learning.test.ds;

import lw.learning.ds.BSTMap;
import lw.learning.ds.LinkedListMap;
import lw.learning.utils.Book;
import lw.learning.utils.DSType;
import lw.learning.utils.TestHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
        List<String> prideAndPrejudice = Book.prideAndPrejudice;

        TestHelper.testDSTime(DSType.MAP, TreeMap.class, prideAndPrejudice);
        TestHelper.testDSTime(DSType.MAP, HashMap.class, prideAndPrejudice);

        TestHelper.testDSTime(DSType.MAP, BSTMap.class, prideAndPrejudice);
        TestHelper.testDSTime(DSType.MAP, LinkedListMap.class, prideAndPrejudice);
    }


}
