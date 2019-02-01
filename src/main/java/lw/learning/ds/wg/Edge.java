package lw.learning.ds.wg;

/**
 * @Author lw
 * @Date 2019-01-31 12:47:08
 **/
public class Edge<T> {

    private int v;
    private int w;

    private T weight;

    public Edge(int v, int w, T weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int v() {
        return v;
    }

    public int w() {
        return w;
    }

    public T weight() {
        return weight;
    }

    public int other(int x) {

        return x == v ? w : v;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
