package lw.learning.ds;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-01-30 20:02:52
 **/
public class DenseGraph implements Graph{

    // 点数
    private int n;
    // 边数
    private int m;

    boolean directed;

    boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new boolean[n][n];
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            return;
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed)
            g[w][v] = true;
        m++;
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }


    class AdjIterator implements Iterator<Integer>{

        private int v;
        private int index;

        public AdjIterator(int v) {
            this.v = v;
            this.index = -1;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < V() - 1; i++) {
                if (g[v][++index]) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            return index;
        }
    }


    @Override
    public Iterator<Integer> iterator(int v) {
        return new AdjIterator(v);
    }

}
