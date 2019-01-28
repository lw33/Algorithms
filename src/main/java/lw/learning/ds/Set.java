package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 15:13:52
 **/
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
