package lw.learning.test.ds;

import lw.learning.algorithms.graph.Component;
import lw.learning.algorithms.graph.Path;
import lw.learning.algorithms.graph.ShortestPath;
import lw.learning.ds.DenseGraph;
import lw.learning.ds.Graph;
import lw.learning.ds.SparseGraph;
import lw.learning.ds.wg.WeightDenseGraph;
import lw.learning.ds.wg.WeightGraph;
import lw.learning.ds.wg.WeightSparseGraph;
import lw.learning.utils.FileOperation;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-31 09:23:31
 **/
public class GraphTest {
    
    @Test
    public void test1() {

        //Graph graph = new DenseGraph(100, false);
        Graph graph = new SparseGraph(100, false);

        for (int i = 0; i < 1000; i++) {
            int i1 = (int) (Math.random() * 100);
            int i2 = (int) (Math.random() * 100);
            graph.addEdge(i1, i2);
        }
        Graph.printGraph(graph);
    }

    @Test
    public void test2() {
        Graph graph1 = FileOperation.readGrap(SparseGraph.class, false, "g1.txt");
        Graph graph2 = FileOperation.readGrap(DenseGraph.class, false, "g2.txt");

        Component component1 = new Component(graph1);
        Component component2 = new Component(graph2);
        System.out.println(component1.isConnected(1,2));
        System.out.println(component1.count());
        System.out.println(component2.count());
    }
    
    @Test
    public void test3() {
        Graph graph1 = FileOperation.readGrap(SparseGraph.class, false, "g1.txt");
        Graph graph2 = FileOperation.readGrap(DenseGraph.class, false, "g2.txt");
        Path path = new Path(graph2, 0);
        path.showPath(6);

        ShortestPath shortestPath = new ShortestPath(graph2, 0);
        shortestPath.showPath(6);
    }

    @Test
    public void test4() {
        WeightGraph weightGraph1 = FileOperation.readWeightGrap(WeightSparseGraph.class, false, "wg2.txt");
        WeightGraph weightGraph2 = FileOperation.readWeightGrap(WeightDenseGraph.class, false, "wg2.txt");
        WeightGraph.printGraph(weightGraph1);
        WeightGraph.printGraph(weightGraph2);

    }


}
