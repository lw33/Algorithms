package lw.learning.ds;

import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2019-01-30 11:35:38
 **/
public class HashMap<K, V> implements Map<K, V>{

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    private static final int initCapacity = 16;
    public static final int upperTol = 10;
    public static final int lowerTol = 2;
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public HashMap() {
        this(initCapacity);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int m) {
        if (m <= initCapacity) {
            m = initCapacity;
        } else {
            m = tableSizeFor(m);
        }
        M = m;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Override
    public void put(K key, V value) {

        TreeMap<K, V> kvTreeMap = hashtable[hash(key)];
        if (!kvTreeMap.containsKey(key)) {
            size++;
        }
        kvTreeMap.put(key, value);
        if (upperTol * M <= size) {
            resize(2 * M);
        }
    }

    @Override
    public V remove(K key) {
        TreeMap<K, V> kvTreeMap = hashtable[hash(key)];
        if (kvTreeMap.containsKey(key)) {
            size--;
        }
        V delVal = kvTreeMap.remove(key);
        if (size < lowerTol * M && M / 2 > initCapacity) {
            resize(M / 2);
        }

        return delVal;
    }

    @Override
    public boolean contains(K key) {

        return hashtable[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {

        M = newCapacity;
        TreeMap<K, V>[] newHashTable = new TreeMap[M];
        for (int i = 0; i < newCapacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        for (TreeMap<K, V> kvTreeMap : hashtable) {
            kvTreeMap.forEach((k, v) -> newHashTable[hash(k)].put(k, v));
        }
        hashtable = newHashTable;
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & (M - 1);
    }
}
