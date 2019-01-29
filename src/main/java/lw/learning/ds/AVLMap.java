package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-29 11:44:48
 **/
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V>{
    private AVLTree<K, V> avlTree = new AVLTree<>();
    @Override
    public void put(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
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
