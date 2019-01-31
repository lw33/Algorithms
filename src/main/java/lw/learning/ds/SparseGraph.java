package lw.learning.ds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-30 21:09:45
 **/
public class SparseGraph implements Graph {

    private int n;
    private int m;

    private boolean directed;
    private List<List<Integer>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>(n));
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            return;
        }
        if (hasEdge(v, w)) {
            return;
        }
        g.get(v).add(w);
        if (v != w && !directed)
            g.get(w).add(v);
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

        for (Integer i : g.get(v)) {
            if (i == w) {
                return true;
            }
        }

        return false;
    }

    class AdjIterator implements Iterator<Integer>{

        private int v;
        private int index;

        public AdjIterator(int v) {
            this.v = v;
        }

        @Override
        public boolean hasNext() {
            return index < g.get(v).size();
        }

        @Override
        public Integer next() {

            return g.get(v).get(index++);
        }
    }


    @Override
    public Iterator<Integer> iterator(int v) {
        return new AdjIterator(v);
    }
}
