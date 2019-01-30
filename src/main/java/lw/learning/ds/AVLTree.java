package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 19:51:53
 **/
public class AVLTree<K extends Comparable<K>, V> {


    private class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;


        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public void add(K key, V value) {
        root = add(key, value, root);
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

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balanceFactor = balanceFactor(node);


        // 左子树高度大于右子树高度
        if (balanceFactor > 1) {
            /*
            // LL
            if (balanceFactor(node.left) >= 0) {
                return rightRotate(node);
            }
            // LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
            */
            // LR
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        // 右子树高度大于左子树高度
        if (balanceFactor < -1) {
           /*
            // RR
            if (balanceFactor(node.right) <= 0) {
                return leftRotate(node);
            }
            // RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
            */
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node node) {

        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;

        // 维护高度
        node.height = 1 + Math.max(height(node.left), height(node.right));
        leftNode.height = 1 + Math.max(height(leftNode.left), height(leftNode.right));

        return leftNode;
    }

    private Node leftRotate(Node node) {

        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;

        // 维护高度
        node.height = 1 + Math.max(height(node.left), height(node.right));
        rightNode.height = 1 + Math.max(height(rightNode.left), height(rightNode.right));

        return rightNode;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        Node retNode = node;

        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                retNode =  right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                retNode = left;
            } else {

                Node successor = min(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                retNode = successor;
            }
        }

        if (retNode == null) {
            return null;
        }

        // 维护高度
        retNode.height = 1 + Math.max(height(retNode.left), height(retNode.right));
        int balanceFactor = balanceFactor(retNode);

        // 左子树高度大于右子树高度
        if (balanceFactor > 1) {

            // LR
            if (balanceFactor(retNode.left) < 0) {
                retNode.left = leftRotate(retNode.left);
            }
            return rightRotate(retNode);
        }

        // 右子树高度大于左子树高度
        if (balanceFactor < -1) {

            if (balanceFactor(retNode.right) > 0) {
                retNode.right = rightRotate(retNode.right);
            }
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node removeMin(Node node) {

        Node retNode = node;
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            retNode = right;
        }else {
            node.left = removeMin(node.left);
        }

        if (retNode == null) {
            return null;
        }

        // 维护高度
        retNode.height = 1 + Math.max(height(retNode.left), height(retNode.right));
        int balanceFactor = balanceFactor(retNode);

        // 左子树高度大于右子树高度
        if (balanceFactor > 1) {

            // LR
            if (balanceFactor(retNode.left) < 0) {
                retNode.left = leftRotate(retNode.left);
            }
            return rightRotate(retNode);
        }

        // 右子树高度大于左子树高度
        if (balanceFactor < -1) {

            if (balanceFactor(retNode.right) > 0) {
                retNode.right = rightRotate(retNode.right);
            }
            return leftRotate(retNode);
        }
        return retNode;
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

    public boolean isBST() {
        if (root == null) {
            return true;
        }
        return isBST(root, min(root).key);
    }

    private boolean isBST(Node node, K pre) {
        if (node == null)
            return true;
        if (!isBST(node.left, pre)) {
            return false;
        }

        if (node.key.compareTo(pre) < 0) {
            return false;
        }

        pre = node.key;

        if (!isBST(node.right, pre)) {
            return false;
        }

        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        if (Math.abs(balanceFactor(node)) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
}
