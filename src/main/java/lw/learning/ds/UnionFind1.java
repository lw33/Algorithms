package lw.learning.ds;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-28 22:01:58
 **/
public class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        IntStream.range(0, size).forEach(i -> id[i] = i);
    }

    // Quick Find
    private int find(int p) {
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
