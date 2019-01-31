package lw.learning.algorithms.graph;

import lw.learning.ds.Graph;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2019-01-31 10:04:18
 **/
public class Component {

    private Graph g;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Component(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < id.length; i++) {
            id[i] = -1;
        }

        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs(int v) {

        visited[v] = true;
        id[v] = ccount;
        Iterator<Integer> adjs = g.iterator(v);
        adjs.forEachRemaining(w -> {
            if (!visited[w])
                dfs(w);
        });

    }

    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return ccount;
    }
}
