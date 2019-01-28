package lw.learning.ds;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-28 20:01:30
 **/
public class Trie implements Set<String>{

    private class Node {
        boolean isWord;
        Map<Character, Node> next = new HashMap<>(32);


        Node(boolean isWord) {
            this.isWord = isWord;
        }

        Node() {
        }
    }

    private Node root = new Node();
    private int size;

    public void add(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            Node node = cur.next.get(aChar);
            if (node == null) {
                cur.next.put(aChar, (node = new Node()));
            }
            cur = node;
        }
        if (!cur.isWord) {
            cur.isWord = true;
            ++size;
        }
    }



    public boolean contains(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            Node node = cur.next.get(aChar);
            if (node == null)
                return false;
            cur = node;
        }
        return cur.isWord;
    }

    public boolean prefix(String prefix) {
        char[] chars = prefix.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            Node node = cur.next.get(aChar);
            if (node == null)
                return false;
            cur = node;
        }
        return true;
    }



    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(String s) {

    }
}
