package lw.learning.algorithms.graph;

import lw.learning.ds.IndexHeap;
import lw.learning.ds.wg.Edge;
import lw.learning.ds.wg.WeightGraph;
import lw.learning.ds.wg.WeightSparseGraph;
import lw.learning.utils.FileOperation;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @Author lw
 * @Date 2019-01-31 10:23:21
 **/
public class Dijkstra<T extends Comparable<T>> {

    private int source;            // 单源最短路径
    private T[] distTo;           // 源点到各顶点的距离
    private boolean[] marked;    // 已经求出最短路径的定点
    private Edge<T>[] from; // 从那个顶点到达
    private BinaryOperator<T> combiner;

    public Dijkstra(WeightGraph<T> g, Comparator<T> comparator, BinaryOperator<T> combiner, int s, T init) {

        this.source = s;
        distTo = (T[]) new Comparable[g.V()];
        marked = new boolean[g.V()];
        from = new Edge[g.V()];

        distTo[s] = init;
        IndexHeap<T> ipq = new IndexHeap<>(g.V(), comparator);
        ipq.add(s, distTo[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.pollIndex();
            marked[v] = true;
            g.iterator(v).forEachRemaining(edge -> {
                int w = edge.other(v);
                if (!marked[w]) {
                    T newWeight = combiner.apply(distTo[v], edge.weight());
                    if (from[w] == null || newWeight.compareTo(distTo[w]) < 0) {
                        distTo[w] = newWeight;
                        from[w] = edge;
                        if (ipq.contains(w)) {
                            ipq.change(w, distTo[w]);
                        } else {
                            ipq.add(w, distTo[w]);
                        }
                    }
                }
            });
        }
    }



    public boolean hasPath(int w) {
        return marked[w];
    }

    public List<Integer> path(int w) {
        LinkedList<Integer> res = new LinkedList<>();
        if (!hasPath(w)) {
            return res;
        }
        while (w != source) {
            res.addFirst(w);
            w = from[w].other(w);
        }
        res.addFirst(source);
        return res;
    }

    public void showPath(int w) {
        List<Integer> path = path(w);

        int index = 0;
        for (Integer integer : path) {
            System.out.print(integer);
            if (index == path.size() - 1) {
                System.out.println();
            } else {
                System.out.print("->");
            }
            index++;
        }
    }

    public static void main(String[] args) {
        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(WeightSparseGraph.class, true, "tg1.txt");

        Comparator<Double> comparator = (d1, d2) -> -d1.compareTo(d2);
        Dijkstra<Double> dijkstra = new Dijkstra<>(weightGraph, comparator, (a, b) -> a + b, 0, 0.0);
        for (int i = 1; i < weightGraph.V(); i++) {
            System.out.println("Shortest Path to " + i );
            dijkstra.showPath(i);
            System.out.println("==========================================");
        }
        System.out.println();
    }
}
