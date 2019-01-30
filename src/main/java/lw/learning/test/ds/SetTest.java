package lw.learning.test.ds;

import lw.learning.ds.*;
import lw.learning.utils.Book;
import lw.learning.utils.DSType;
import lw.learning.utils.TestHelper;
import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

/**
 * @Author lw
 * @Date 2019-01-27 17:14:51
 **/
public class SetTest {

    @Test
    public void test() {
        List<String> twoCities = Book.twoCities;
        List<String> prideAndPrejudice = Book.prideAndPrejudice;

        BSTSet<String> bstSet1 = new BSTSet<>();
        LinkedListSet<String> listSet1 = new LinkedListSet<>();

        System.out.println(Book.twoCitiesBook + ": ");

        TestHelper.testSetTime(bstSet1, twoCities);
        TestHelper.testSetTime(listSet1, twoCities);

        BSTSet<String> bstSet2 = new BSTSet<>();
        LinkedListSet<String> listSet2 = new LinkedListSet<>();

        System.out.println(Book.prideAndPrejudiceBook + ": ");

        TestHelper.testSetTime(bstSet2, prideAndPrejudice);
        TestHelper.testSetTime(listSet2, prideAndPrejudice);
    }

    @Test
    public void benchmark() {
        List<String> twoCities = Book.twoCities;

        TestHelper.testDSTime(DSType.SET, BSTSet.class, twoCities);
        TestHelper.testDSTime(DSType.SET, AVLSet.class, twoCities);
        TestHelper.testDSTime(DSType.SET, RBTreeSet.class, twoCities);
        TestHelper.testDSTime(DSType.SET, Trie.class, twoCities);
        TestHelper.testDSTime(DSType.SET, lw.learning.ds.HashSet.class,9944, twoCities);

        System.out.println("jdk: ");
        TestHelper.testDSTime(DSType.SET, TreeSet.class, twoCities);
        TestHelper.testDSTime(DSType.SET, java.util.HashSet.class, 6535, twoCities);

        //TestHelper.testDSTime(DSType.SET, LinkedListSet.class, twoCities);
    }
}
