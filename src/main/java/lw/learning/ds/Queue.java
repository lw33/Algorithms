package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 09:52:22
 **/
public interface Queue<E> {

    void add(E e);

    E poll();

    E peek();

    int size();

    boolean isEmpty();
}
