package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-29 11:56:47
 **/
public class RBTreeSet<K extends Comparable<K>> implements Set<K> {

    private RBTree<K, Object> rbTree = new RBTree<>();

    @Override
    public void add(K k) {
        rbTree.add(k, null);
    }

    @Override
    public void remove(K k) {
        rbTree.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return rbTree.contains(k);
    }

    @Override
    public int size() {
        return rbTree.size();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }
}
