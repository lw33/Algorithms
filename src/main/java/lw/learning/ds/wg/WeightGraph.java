package lw.learning.ds.wg;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-01-31 12:50:43
 **/
public interface WeightGraph<T> {

    int V();

    int E();

    void addEdge(int v, int w, T weight);

    boolean hasPath(int v, int w);

    Iterator<Edge<T>> iterator(int v);

    static void printGraph(WeightGraph<?> graph) {
        System.out.println(graph.V() + " vertexes ");
        for (int i = 0; i < graph.V(); i++) {
            System.out.print(i + ": ");
            graph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }
    }

}
