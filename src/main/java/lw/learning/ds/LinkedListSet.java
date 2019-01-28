package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 17:28:14
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void add(E e) {
        if (contains(e)) {
            return;
        }
        list.addLast(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
