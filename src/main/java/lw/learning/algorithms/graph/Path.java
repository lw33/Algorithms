package lw.learning.algorithms.graph;

import lw.learning.ds.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-31 10:23:21
 **/
public class Path {

    private boolean[] visited;
    private int[] from;
    private Graph g;
    private int s;

    public Path(Graph g, int s) {

        this.g = g;
        this.s = s;
        visited = new boolean[g.V()];
        from = new int[g.V()];

        dfs(s);
    }

    private void dfs(Integer v) {
        visited[v] = true;
        g.iterator(v).forEachRemaining(w -> {
            if (!visited[w]) {
                from[w] = v;
                dfs(w);
            }
        });
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
}
