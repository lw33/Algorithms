package lw.learning.algorithms.graph;


import lw.learning.ds.wg.Edge;
import lw.learning.ds.wg.WeightGraph;
import lw.learning.ds.wg.WeightSparseGraph;
import lw.learning.utils.FileOperation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BinaryOperator;

/**
 * @Author lw
 * @Date 2019-01-31 18:14:48
 **/
public class LazyPrimMST<T> implements MST<T>{

    private PriorityQueue<Edge<T>> pq;
    private boolean[] marked;
    private List<Edge<T>> mst;
    private T mstWeight;
    private BinaryOperator<T> combiner;
    private WeightGraph<T> g;

    public LazyPrimMST(WeightGraph<T> g, BinaryOperator<T> combiner, Comparator<Edge<T>> comparator, T mstInit) {

        this.g = g;
        this.combiner = combiner;
        this.mstWeight = mstInit;
        marked = new boolean[g.V()];
        mst = new ArrayList<>(g.V() - 1);
        pq = new PriorityQueue<>(comparator);

        visit(0);
        while (!pq.isEmpty()) {
            Edge<T> edge = pq.poll();
            if (marked[edge.v()] == marked[edge.w()]) {
                continue;
            }
            mstWeight = combiner.apply(mstWeight, edge.weight());
            mst.add(edge);
            if (mst.size() == g.V() - 1) {
                break;
            }
            if (!marked[edge.v()]) {
                visit(edge.v());
            } else {
                visit(edge.w());
            }
        }
    }

    private void visit(int v) {

        marked[v] = true;
        g.iterator(v).forEachRemaining(e -> {
            if (!marked[e.other(v)]) {
                pq.add(e);
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
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(weightGraph, (a, b) -> a + b, Comparator.comparing(Edge::weight), 0.0);
        List<Edge<Double>> mst = lazyPrimMST.mst();
        mst.forEach(e -> {
            System.out.print(e.v() + "--" + e.w() + ": " + e.weight());
            System.out.println();
        });
        System.out.println(lazyPrimMST.mstWeight());
    }

}
