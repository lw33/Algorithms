package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-29 11:44:48
 **/
public class RBTreeMap<K extends Comparable<K>, V> implements Map<K, V>{
    private RBTree<K, V> rbTree = new RBTree<>();
    @Override
    public void put(K key, V value) {
        rbTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return rbTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return rbTree.contains(key);
    }

    @Override
    public V get(K key) {
        return rbTree.get(key);
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
