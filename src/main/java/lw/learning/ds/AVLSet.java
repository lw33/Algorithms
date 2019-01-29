package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-29 11:56:47
 **/
public class AVLSet<K extends Comparable<K>> implements Set<K> {

    private AVLTree<K, Object> avlTree = new AVLTree<>();

    @Override
    public void add(K k) {
        avlTree.add(k, null);
    }

    @Override
    public void remove(K k) {
        avlTree.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }

    @Override
    public int size() {
        return avlTree.size();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
