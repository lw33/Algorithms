package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-27 10:59:29
 **/
public class LinkedList<E> {

    private class Node {
        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public int size() {
        return size;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void addLast(E e) {
        if (head == null) {
            head = tail = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        rangeCheckForAdd(index);
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            //Node node = new Node(value);
            //node.next = pre.next;
            //pre.next = node;
            pre.next = new Node(e, pre.next);
            size++;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E ret;
        Node oldHead;
        if (head == tail) {
            oldHead = head;
            head = tail = null;
        } else {
            oldHead = head;
            head = head.next;
        }
        ret = oldHead.value;
        oldHead.next = null;
        size--;
        return ret;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        rangeCheck(index);
        if (index == 0) {
            return removeFirst();
        } else {
            Node pre = head;
            --index;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            --size;
            return delNode.value;
        }
    }

    public boolean remove(E e) {
        if (isEmpty()) {
            return false;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            if (cur.value.equals(e)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        if (pre == null) {
            removeFirst();
        } else {
            pre.next = cur.next;
            cur.next = null;
            --size;
        }
        return true;
    }

    public E set(int index, E e) {
        Node node = getNode(index);
        E oldValue = node.value;
        node.value = e;
        return oldValue;
    }

    public E get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        rangeCheck(index);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.value;
    }

    public boolean contains(E e) {
        Node cur = head;
        while (cur != null) {
            if (cur.value.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value).append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
