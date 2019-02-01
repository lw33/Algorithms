package lw.learning.algorithms.graph;

import lw.learning.ds.IndexHeap;
import lw.learning.ds.wg.Edge;
import lw.learning.ds.wg.WeightGraph;
import lw.learning.ds.wg.WeightSparseGraph;
import lw.learning.utils.FileOperation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @Author lw
 * @Date 2019-01-31 20:29:37
 **/
public class PrimMST<T extends Comparable<T>> implements MST<T>{

    private IndexHeap<T> pq;
    private List<Edge<T>> edgeTo;

    private boolean[] marked;
    private List<Edge<T>> mst;
    private T mstWeight;
    private BinaryOperator<T> combiner;
    private WeightGraph<T> g;


    public PrimMST(WeightGraph<T> g, BinaryOperator<T> combiner, Comparator<T> comparator, T mstInit) {

        this.g = g;
        this.combiner = combiner;
        this.mstWeight = mstInit;
        marked = new boolean[g.V()];
        mst = new ArrayList<>(g.V() - 1);
        pq = new IndexHeap<>(g.V(), comparator);
        edgeTo = new ArrayList<>(g.V());
        for (int i = 0; i < g.V(); i++) {
            edgeTo.add(null);
        }

        visit(0);
        while (!pq.isEmpty()) {
            int v = pq.pollIndex();
            Edge<T> edge = edgeTo.get(v);
            mst.add(edge);
            mstWeight = combiner.apply(mstWeight, edge.weight());
            visit(v);
        }
    }

    private void visit(int v) {

        marked[v] = true;
        g.iterator(v).forEachRemaining(e -> {
            int w = e.other(v);
            if (!marked[w]) {
                if (edgeTo.get(w) == null) {
                    pq.add(w, e.weight());
                    edgeTo.set(w, e);
                } else if (edgeTo.get(w).weight().compareTo(e.weight()) > 0) {
                    pq.change(w, e.weight());
                    edgeTo.set(w, e);
                }
            }
        });
    }


    public T mstWeight() {
        return mstWeight;
    }

    public List<Edge<T>> mst() {
        return mst;
    }

    public static void main(String[] args) {

        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(WeightSparseGraph.class, false, "wg1.txt");
        PrimMST<Double> primMST = new PrimMST<>(weightGraph, (a, b) -> a + b, (d1, d2) -> -d1.compareTo(d2), 0.0);

        List<Edge<Double>> mst = primMST.mst();
        mst.forEach(e -> {
            System.out.print(e.v() + "--" + e.w() + ": " + e.weight());
            System.out.println();
        });
        System.out.println(primMST.mstWeight());

    }

}
