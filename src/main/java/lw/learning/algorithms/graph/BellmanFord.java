package lw.learning.algorithms.graph;

import lw.learning.ds.wg.Edge;
import lw.learning.ds.wg.WeightGraph;
import lw.learning.ds.wg.WeightSparseGraph;
import lw.learning.utils.FileOperation;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @Author lw
 * @Date 2019-01-31 10:23:21
 **/
public class BellmanFord<T extends Comparable<T>> {

    private WeightGraph g;    // 图的引用
    private int s;              // 起始点
    private T[] distTo;    // distTo[i]存储从起始点s到i的最短路径长度
    private Edge<T>[] from;        // from[i]记录最短路径中, 到达i点的边是哪一条
    // 可以用来恢复整个最短路径
    boolean hasNegativeCycle;   // 标记图中是否有负权环
    private BinaryOperator<T> combiner;

    public BellmanFord(WeightGraph<T> g, Comparator<T> comparator, BinaryOperator<T> combiner, int s, T init) {
        this.g = g;
        this.combiner = combiner;
        this.s = s;
        from = new Edge[g.V()];
        distTo = (T[]) new Comparable[g.V()];

        distTo[s] = init;

        for (int pass = 1; pass < g.V(); pass++) {
            for (int i = 0; i < g.V(); i++) {
                g.iterator(i).forEachRemaining(e -> {
                    T newWeight = combiner.apply(distTo[e.v()], e.weight());
                    if (from[e.w()] == null || newWeight.compareTo(distTo[e.w()]) < 0) {
                        distTo[e.w()] = newWeight;
                        from[e.w()] = e;
                    }
                });
            }
        }

        hasNegativeCycle = hasNegativeCycle();
    }

    public boolean hasNegativeCycle() {
        for (int i = 0; i < g.V(); i++) {
            Iterator<Edge<T>> iterator = g.iterator(i);
            while (iterator.hasNext()) {
                Edge<T> e = iterator.next();
                T newWeight = combiner.apply(distTo[e.v()], e.weight());
                if (from[e.w()] == null || newWeight.compareTo(distTo[e.w()]) < 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean hasPath(int w) {
        return from[w] != null;
    }

    public List<Integer> path(int w) {
        LinkedList<Integer> res = new LinkedList<>();
        if (!hasPath(w)) {
            return res;
        }
        while (w != s) {
            res.addFirst(w);
            w = from[w].other(w);
        }
        res.addFirst(s);
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
        BellmanFord<Double> dijkstra = new BellmanFord<>(weightGraph, comparator, (a, b) -> a + b, 0, 0.0);
        for (int i = 1; i < weightGraph.V(); i++) {
            System.out.println("Shortest Path to " + i);
            dijkstra.showPath(i);
            System.out.println("==========================================");
        }
        System.out.println();
    }
}
