package lw.learning.ds;

import java.util.Currency;

/**
 * @Author lw
 * @Date 2019-01-27 19:28:53
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(){

        }

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node dummyHead = new Node();
    private int size;


    @Override
    public void put(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {

        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                --size;
                return delNode.value;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
