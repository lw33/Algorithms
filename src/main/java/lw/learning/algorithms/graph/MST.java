package lw.learning.algorithms.graph;

import lw.learning.ds.wg.Edge;

import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-31 21:24:46
 **/
public interface MST<T> {

    T mstWeight();

    List<Edge<T>> mst();

}
