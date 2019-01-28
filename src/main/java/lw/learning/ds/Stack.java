package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 09:25:36
 **/
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int search(E e);

    boolean isEmpty();

    int size();
}
