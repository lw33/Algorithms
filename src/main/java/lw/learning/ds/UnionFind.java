package lw.learning.ds;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-29 09:39:34
 **/
public class UnionFind implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        IntStream.range(0, size).forEach(i -> {
            parent[i] = i;
            rank[i] = 1;
        });
    }

    private int find(int p) {
        while (p != parent[p]) {
           p = parent[p] = parent[parent[p]];
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }

    }

    @Override
    public int size() {
        return parent.length;
    }

}