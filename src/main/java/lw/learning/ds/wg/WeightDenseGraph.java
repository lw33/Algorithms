package lw.learning.ds.wg;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-01-31 12:53:17
 **/
public class WeightDenseGraph<T> implements WeightGraph<T> {

    private int n;
    private int m;
    private boolean directed;
    private Edge<T>[][] g;

    public WeightDenseGraph(int n, boolean directed) {
        this.n = n;
        g = new Edge[n][n];
        this.directed = directed;
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
    public void addEdge(int v, int w, T weight) {

        if (hasPath(v, w)) {
            --m;
        }

        g[v][w] = new Edge<>(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge<>(w, v, weight);
        }
        m++;
    }

    @Override
    public boolean hasPath(int v, int w) {

        return g[v][w] != null;
    }

    class AdjIterator implements Iterator<Edge<T>> {

        private int index;
        private int v;

        public AdjIterator(int v) {
            this.v = v;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < V() - 1; i++) {
                if (g[v][++index] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Edge<T> next() {
            return g[v][index];
        }
    }

    @Override
    public Iterator<Edge<T>> iterator(int v) {
        return new AdjIterator(v);
    }

}
