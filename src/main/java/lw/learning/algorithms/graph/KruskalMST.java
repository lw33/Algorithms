package lw.learning.algorithms.graph;

import lw.learning.ds.UnionFind;
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
 * @Date 2019-01-31 21:23:02
 **/
public class KruskalMST<T> implements MST<T>{

    private List<Edge<T>> mst;
    private T mstWeight;

    public KruskalMST(WeightGraph<T> graph,BinaryOperator<T> combiner, Comparator<Edge<T>> comparator, T mstInit) {

        mstWeight = mstInit;
        mst = new ArrayList<>(graph.V());

        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(comparator);
        for (int i = 0; i < graph.V(); i++) {
            graph.iterator(i).forEachRemaining(e -> {
                // 去重
                if (e.v() < e.w()) {
                    pq.add(e);
                }
            });
        }

        UnionFind uf = new UnionFind(graph.V());
        while (!pq.isEmpty() || mst.size() < graph.V() - 1) {

            Edge<T> edge = pq.poll();
            if (uf.isConnected(edge.v(), edge.w())) {
                continue;
            }
            mst.add(edge);
            mstWeight = combiner.apply(mstWeight, edge.weight());
            uf.union(edge.v(), edge.w());
        }
    }

    @Override
    public T mstWeight() {
        return mstWeight;
    }

    @Override
    public List<Edge<T>> mst() {
        return mst;
    }

    public static void main(String[] args) {

        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(WeightSparseGraph.class, false, "wg1.txt");
        KruskalMST<Double> kruskalMST = new KruskalMST<>(weightGraph, (a, b) -> a + b,
                Comparator.comparing(Edge::weight), 0.0);

        List<Edge<Double>> mst = kruskalMST.mst();
        mst.forEach(e -> {
            System.out.print(e.v() + "--" + e.w() + ": " + e.weight());
            System.out.println();
        });
        System.out.println(kruskalMST.mstWeight());

    }
}
