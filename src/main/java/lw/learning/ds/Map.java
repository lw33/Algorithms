package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 19:25:59
 **/
public interface Map<K, V> {

    void put(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    int size();

    boolean isEmpty();


}
