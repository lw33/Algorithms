package lw.learning.ds.wg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-31 12:53:59
 **/
public class WeightSparseGraph<T> implements WeightGraph<T> {

    private int n;
    private int m;
    private boolean directed;
    private List<List<Edge<T>>> g;

    public WeightSparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
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
        g.get(v).add(new Edge<>(v, w, weight));
        if (!directed) {
            g.get(w).add(new Edge<>(w, v, weight));
        }
        m++;
    }

    @Override
    public boolean hasPath(int v, int w) {
        for (Edge<T> edge : g.get(v)) {
            if (edge.w() == w) {
                return true;
            }
        }
        return false;
    }

    class AdjIterator implements Iterator<Edge<T>> {

        private int index;
        private int v;

        public AdjIterator(int v) {
            this.v = v;
        }

        @Override
        public boolean hasNext() {

            return g.get(v).size() > index;
        }

        @Override
        public Edge<T> next() {

            return g.get(v).get(index++);
        }

    }

    @Override
    public Iterator<Edge<T>> iterator(int v) {
        return new AdjIterator(v);
    }
}
