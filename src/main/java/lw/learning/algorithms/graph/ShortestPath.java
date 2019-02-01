package lw.learning.algorithms.graph;

import lw.learning.ds.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-31 10:23:21
 **/
public class ShortestPath {

    private boolean[] visited;
    private int[] from;
    private Graph g;
    private int s;
    private int[] ord;

    public ShortestPath(Graph g, int s) {

        this.g = g;
        this.s = s;
        visited = new boolean[g.V()];
        from = new int[g.V()];
        ord = new int[g.V()];
        for (int i = 0; i < ord.length; i++) {
            ord[i] = -1;
        }
        bfs(s);
    }

    public void bfs(int s) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        ord[s] = 0;
        visited[s] = true;

        while (!queue.isEmpty()) {

            Integer v = queue.poll();
            int distance = ord[v] + 1;
            g.iterator(v).forEachRemaining(w -> {
                if (!visited[w]) {
                    from[w] = v;
                    visited[w] = true;
                    ord[w] = distance;
                    queue.add(w);
                }
            });
        }
    }

    public boolean hasPath(int w) {
        return visited[w];
    }

    public List<Integer> path(int w) {
        LinkedList<Integer> res = new LinkedList<>();
        if (!hasPath(w)) {
            return res;
        }
        while (w != s) {
            res.addFirst(w);
            w = from[w];
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

    public int length(int w) {
        return ord[w];
    }
}
