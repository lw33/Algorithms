package lw.learning.ds;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-01-30 20:01:56
 **/
public interface Graph {

    void addEdge(int v, int w);

    int V();

    int E();

    boolean hasEdge(int v, int w);

    Iterator<Integer> iterator(int v);

    static void printGraph(Graph graph) {
        System.out.println(graph.V() + " vertexes ");
        for (int i = 0; i < graph.V(); i++) {
            System.out.print(i + ": ");
            graph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }
    }
}
