package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 19:51:53
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {


    private class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private Node put(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {
            node.left = put(key, value, node.left);
        } else if (node.key.compareTo(key) < 0) {
            node.right = put(key, value, node.right);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            } else {

                Node successor = min(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                return successor;
            }
        }
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
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

    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
}
