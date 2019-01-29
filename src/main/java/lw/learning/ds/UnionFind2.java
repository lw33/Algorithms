package lw.learning.ds;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-29 08:37:28
 **/
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        IntStream.range(0, size).forEach(i -> parent[i] = i);
    }

    private int find(int p) {

        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;

    }

    @Override
    public int size() {
        return parent.length;
    }

}
