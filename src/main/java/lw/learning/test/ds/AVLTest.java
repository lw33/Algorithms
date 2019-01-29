package lw.learning.test.ds;

import lw.learning.ds.AVLTree;
import lw.learning.ds.BST;
import lw.learning.utils.Book;
import org.junit.Test;

import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-29 17:17:10
 **/
public class AVLTest {

    @Test
    public void test() {
        AVLTree<String, Integer> avlTree = new AVLTree<>();
        List<String> prideAndPrejudice = Book.prideAndPrejudice;
        for (String s : prideAndPrejudice) {
            avlTree.add(s, 1);
        }

        System.out.println(avlTree.isBalanced());
        System.out.println(avlTree.isBST());

        System.out.println(avlTree.get("pride"));
        System.out.println(avlTree.remove("pride"));
        System.out.println(avlTree.get("pride"));

        for (String s : prideAndPrejudice) {
            avlTree.remove(s);
            System.out.println(avlTree.isBalanced());
            System.out.println(avlTree.isBST());
        }

    }

    @Test
    public void test2() {
        BST<String> bst = new BST<>();
        List<String> prideAndPrejudice = Book.prideAndPrejudice;
        for (String s : prideAndPrejudice) {
            bst.add(s);
        }
        for (String s : prideAndPrejudice) {
            bst.remove(s);
            System.out.println(bst.size());
        }
    }
}
