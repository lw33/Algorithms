package lw.learning.ds;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-29 09:39:34
 **/
public class UnionFind6 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind6(int size) {
        parent = new int[size];
        sz = new int[size];
        IntStream.range(0, size).forEach(i -> {
            parent[i] = i;
            sz[i] = 1;
        });
    }

    private int find(int p) {
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];

        }

    }

    @Override
    public int size() {
        return parent.length;
    }

}