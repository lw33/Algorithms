package lw.learning.test.ds;

import lw.learning.ds.LinkedList;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-27 11:32:11
 **/
public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.set(1, 666));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.remove(new Integer(3)));
        System.out.println(linkedList.remove(new Integer(1)));
        //linkedList.remove(3);
        System.out.println(linkedList);
    }
}
