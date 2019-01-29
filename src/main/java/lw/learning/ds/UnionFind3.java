package lw.learning.ds;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-29 08:37:28
 **/
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        IntStream.range(0, size).forEach(i -> {
            parent[i] = i;
            sz[i] = 1;
        });
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }

    @Override
    public int size() {
        return parent.length;
    }

}
