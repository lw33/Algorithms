package lw.learning.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-27 15:07:03
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E value;
        public Node left;
        public Node right;

        public Node(E value) {
            this.value = value;
        }

    }

    private Node root;
    private int size;


    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.value.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.value.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.value.compareTo(e) > 0) {
            node.left = remove(node.left, e);
        } else if (node.value.compareTo(e) < 0) {
            node.right = remove(node.right, e);
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
                node.left = node.right = null;

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

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (node.value.compareTo(e) == 0) {
            return true;
        } else if (node.value.compareTo(e) > 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        List<E> list = new ArrayList<>(size);
        preOrder(root, list);
        System.out.println(list);
    }

    public void preOrderNR() {
        LinkedList<Node> stack = new LinkedList<>();
        ArrayList<E> list = new ArrayList<>(size);
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println(list);
    }

    private void preOrder(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public void inOrder() {
        List<E> list = new ArrayList<>(size);
        inOrder(root, list);
        System.out.println(list);
    }

    private void inOrder(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }

    public void postOrder() {
        List<E> list = new ArrayList<>(size);
        postOrder(root, list);
        System.out.println(list);
    }

    private void postOrder(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.value);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
