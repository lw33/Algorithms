package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-30 11:52:09
 **/
public class HashSet<K> implements Set<K> {

    private HashMap<K, Object> hashMap;

    public HashSet(){
        hashMap = new HashMap<>();
    }

    public HashSet(int initCapacity) {
        hashMap = new HashMap<>(initCapacity);
    }

    @Override
    public void add(K k) {
        hashMap.put(k, null);
    }

    @Override
    public void remove(K k) {
        hashMap.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return hashMap.contains(k);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }
}
