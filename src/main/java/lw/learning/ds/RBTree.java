package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 19:51:53
 **/
public class RBTree<K extends Comparable<K>, V> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color = RED;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

 
    public void add(K key, V value) {
        root = add(key, value, root);
        root.color = BLACK;
    }

    private Node add(K key, V value, Node node) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {
            node.left = add(key, value, node.left);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(key, value, node.right);
        } else {
            node.value = value;
        }


        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    // 左旋
    private Node leftRotate(Node node) {

        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;

        // 维护颜色
        rightNode.color = node.color;
        node.color = RED;
        return rightNode;
    }

    // 右旋
    private Node rightRotate(Node node) {

        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;

        leftNode.color = node.color;
        node.color = RED;


        return leftNode;
    }

    // 颜色翻转
    private void flipColors(Node node) {

        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }



 
    public V remove(K key) {

        return null;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


 
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

 
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

 
    public int size() {
        return size;
    }

 
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

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }
}
